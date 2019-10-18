package com.paracamplus.ilp1.ilp1tme1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.ast.ASTstring;
import com.paracamplus.ilp1.ilp1tme1.sequence.ASTfactory;
import com.paracamplus.ilp1.ilp1tme1.sequence.IASTsequence;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;


public class ExtensionTestTME1  {

	@Test
	public  void Test1() {
	
	ASTexpression [] expression = 
		{new ASTstring("arrezki"), new ASTstring("galou"), new ASTstring("kichou"),new ASTstring("yanis")};
	ASTfactory f =new ASTfactory();
	IASTsequence seq= f.newSequence(expression);
	try {
		assertEquals(seq.getAllButLastInstructions().length, seq.getExpressions().length-1);
		assertEquals(seq.getAllButLastInstructions()[0],expression[0] );
		assertEquals(seq.getAllButLastInstructions()[1],expression[1] );
		assertEquals(seq.getAllButLastInstructions()[2],expression[2] );
		assertNotEquals(seq.getAllButLastInstructions()[0], expression[1]);
		
	} catch (EvaluationException e) {
		
		e.printStackTrace();
	}
	
	}
	
}
