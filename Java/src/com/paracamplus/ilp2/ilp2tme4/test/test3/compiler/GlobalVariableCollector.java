/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.ilp2tme4.test.test3.compiler;

import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTCvisitor;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;

public class GlobalVariableCollector extends com.paracamplus.ilp2.compiler.GlobalVariableCollector implements IASTCvisitor<Set<IASTCglobalVariable>, 
Set<IASTCglobalVariable>, 
CompilationException> {
	
	@Override
	public Set<IASTCglobalVariable> visit(
            IASTunless iast,
            Set<IASTCglobalVariable> result) 
                    throws CompilationException {
        result = iast.getCondition().accept(this, result);
        result = iast.getConsequence().accept(this, result);
 
        return result;
    }
   
}
