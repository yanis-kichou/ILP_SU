package com.paracamplus.ilp2.ilp2tme4.test.test3.compiler.test.normalizer;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.test.test3.compiler.test.normalizer.INormalizationFactory;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;


public class Normalizer 
extends com.paracamplus.ilp2.compiler.normalizer.Normalizer 
implements 
 IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

	public Normalizer(INormalizationFactory factory) {
		super(factory);
		
	}

	@Override
	public IASTexpression visit(IASTunless iast, INormalizationEnvironment data) throws CompilationException {
		
		IASTexpression c = iast.getCondition().accept(this, data);
        IASTexpression t = iast.getConsequence().accept(this, data);
        return factory.newAlternative(c, factory.newBooleanConstant("false"), t);
        }

}
