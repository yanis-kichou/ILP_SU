package com.paracamplus.ilp2.ilp2tme4.test.test2;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends com.paracamplus.ilp2.interfaces.IASTfactory{

	IASTexpression newUnless(IASTexpression condition,
            IASTexpression consequence);
    
}
