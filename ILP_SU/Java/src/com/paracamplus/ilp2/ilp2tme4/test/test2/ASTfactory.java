package com.paracamplus.ilp2.ilp2tme4.test.test2;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.ast.ASTunless;
import com.paracamplus.ilp2.ilp2tme4.test.test2.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory implements IASTfactory {


	@Override
	public IASTexpression newUnless(IASTexpression condition, IASTexpression consequence) {

		return new ASTunless(condition, consequence);
	}

}
