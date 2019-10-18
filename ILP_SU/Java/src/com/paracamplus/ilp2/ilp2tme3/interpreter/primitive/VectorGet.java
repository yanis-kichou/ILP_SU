package com.paracamplus.ilp2.ilp2tme3.interpreter.primitive;

import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class VectorGet extends Primitive {

	public VectorGet(String name) {
		super(name);
	}

	@Override
	public int getArity() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public Object apply(Object o,Object o1) throws EvaluationException {
		if(o instanceof Vector && o1 instanceof BigInteger) {
			return ((Vector<?>)o).get(((BigInteger)o1).intValue());
	}
		throw new EvaluationException("Not a vector VectorGet");
	}
}
