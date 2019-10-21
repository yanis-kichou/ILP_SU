/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.ilp2tme4.test.test3.compiler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import com.paracamplus.ilp1.ast.ASTalternative;
import com.paracamplus.ilp1.ast.ASTboolean;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.NoDestination;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.compiler.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp2.ilp2tme4.test.test3.compiler.FreeVariableCollector;
import com.paracamplus.ilp2.ilp2tme4.test.test3.compiler.GlobalVariableCollector;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.ilp2tme4.test.test3.compiler.test.normalizer.INormalizationFactory;
import com.paracamplus.ilp2.ilp2tme4.test.test3.compiler.test.normalizer.NormalizationFactory;
import com.paracamplus.ilp2.ilp2tme4.test.test3.compiler.test.normalizer.Normalizer;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.interfaces.IASTprogram;


public class Compiler extends com.paracamplus.ilp2.compiler.Compiler 
implements IASTCvisitor<Void, Compiler.Context, CompilationException>{
    
 
    public Compiler(IOperatorEnvironment ioe, IGlobalVariableEnvironment igve) {
		super(ioe, igve);
	}
    public IASTCprogram normalize(IASTprogram program) 
            throws CompilationException {
        INormalizationFactory nf = new NormalizationFactory();
        Normalizer normalizer = new Normalizer(nf);
        IASTCprogram newprogram = normalizer.transform(program);
        return newprogram;
    }
    @Override
	public Void visit(IASTunless iast, Context context) throws CompilationException{
    	IASTalternative i =new ASTalternative(iast.getCondition(), new ASTboolean("false"), iast.getConsequence());
		i.accept(this, context);
    	return null;
    
    }
    @Override
    public String compile(com.paracamplus.ilp1.interfaces.IASTprogram program) throws CompilationException  {
    	return compile((IASTprogram)program);
    }

    public String compile(IASTprogram program) 
            throws CompilationException {
        
        IASTCprogram newprogram = normalize(program);
        newprogram = ((IASTCprogram) optimizer.transform(newprogram));

        GlobalVariableCollector gvc = new GlobalVariableCollector();
        Set<IASTCglobalVariable> gvs = gvc.analyze(newprogram);
        newprogram.setGlobalVariables(gvs);
        
        FreeVariableCollector fvc = new FreeVariableCollector(newprogram);
        newprogram = (fvc.analyze());
      
        Context context = new Context(NoDestination.NO_DESTINATION);
        StringWriter sw = new StringWriter();
        try {
            out = new BufferedWriter(sw);
            visit(newprogram, context);
            out.flush();
        } catch (IOException exc) {
            throw new CompilationException(exc);
        }
        return sw.toString();
    }
  }
