package com.paracamplus.ilp2.ilp2tme3.interpreter.primitive;

import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class VectorLength extends UnaryPrimitive{

	public VectorLength(String name) {
		super(name);
	}

	@Override
	public Object apply(Object v) throws EvaluationException {
		if(v instanceof Vector) {
			return BigInteger.valueOf(((Vector<?>)v).capacity());
		}
		throw new EvaluationException("not a Vector VectorLength");
	}

}
