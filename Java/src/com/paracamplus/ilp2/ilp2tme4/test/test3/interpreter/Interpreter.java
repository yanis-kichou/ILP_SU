package com.paracamplus.ilp2.ilp2tme4.test.test3.interpreter;


import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;



public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {
    

    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
			IOperatorEnvironment operatorEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment);
	}

	@Override
	public Object visit(IASTunless iast, ILexicalEnvironment data) throws EvaluationException {
		Object c = iast.getCondition().accept(this, data);
        if ( c != null && c instanceof Boolean ) {
            Boolean b = (Boolean) c;
            if ( !b.booleanValue() ) {
            	return iast.getConsequence().accept(this, data);
            } else {
            	return Boolean.FALSE;
            }
        }else
        	return Boolean.FALSE;
        }
}