package com.paracamplus.ilp2.ilp2tme3.interpreter.primitive;

import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class MakeVector extends Primitive{

	public MakeVector(String name) {
		super(name);
	}


	@Override
	public int getArity() {
		return 2;
	}
	
	@Override
	public Object apply(Object o,Object o2) throws EvaluationException {
		if (o instanceof BigInteger) {
			int length=((BigInteger)o).intValue();
			Vector<Object> v =new Vector<Object>(length);
			for (int i=0;i<length;i++) {
				v.add(o2);
			}
		return v;
		}
		throw new EvaluationException("not a number MakeVector");
	}

}
