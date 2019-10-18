package com.paracamplus.ilp2.ilp2tme4.ast;

import com.paracamplus.ilp1.ast.ASTalternative;
import com.paracamplus.ilp1.ast.ASTboolean;
import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
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
	public <Result, Data, Anomaly extends Throwable> Result accept(IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		IASTalternative alternatif=new ASTalternative(condition, new ASTboolean("false"), consequence);
		return visitor.visit(alternatif, data);
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
