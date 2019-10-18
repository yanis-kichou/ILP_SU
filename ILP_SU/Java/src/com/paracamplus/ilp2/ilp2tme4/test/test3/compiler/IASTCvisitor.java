package com.paracamplus.ilp2.ilp2tme4.test.test3.compiler;

import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;

public interface IASTCvisitor <Result, Data, Anomaly extends  Throwable>  {
	 Result visit(IASTunless iast, Data data) throws Anomaly;
}
