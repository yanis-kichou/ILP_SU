package com.paracamplus.ilp2.ilp2tme4.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;

public class ASTunless extends ASTexpression implements IASTunless{

	private final IASTexpression condition;
	private final IASTexpression consequence;
	
	public ASTunless(IASTexpression condition,
            IASTexpression consequence) {
		this.condition = condition;
		this.consequence = consequence;
	}

	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		return ((IASTvisitor <Result, Data, Anomaly>)visitor).visit(this, data);
	}

	@Override
	public IASTexpression getCondition() {
		return condition;
	}

	@Override
	public IASTexpression getConsequence() {
		return consequence;
	}

	
}
