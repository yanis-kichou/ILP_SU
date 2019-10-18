package com.paracamplus.ilp2.ilp2tme3.interpreter.primitive;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class Sinus extends UnaryPrimitive {

	public Sinus(String name) {
		super(name);
	}

	@Override
	public Object apply(Object v) throws EvaluationException {
		
		if(v instanceof BigInteger) {
			return new BigDecimal(((BigInteger)v).intValue());
		}
		
		if(v instanceof BigDecimal) {
			return new BigDecimal(((BigDecimal)v).doubleValue());
		}
		
		throw new EvaluationException("not a Number ");
	}
	

}
