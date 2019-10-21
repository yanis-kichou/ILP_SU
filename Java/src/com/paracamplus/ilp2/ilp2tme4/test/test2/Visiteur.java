package com.paracamplus.ilp2.ilp2tme4.test.test2;

import com.paracamplus.ilp1.ast.ASTblock.ASTbinding;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.ilp2tme4.ast.ASTfactory;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTfactory;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.ilp2tme4.interfaces.IASTvisitor;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;

public class Visiteur implements IASTvisitor<IASTexpression,Void,Throwable> {
	
	IASTfactory f =new ASTfactory();
	
	public IASTprogram visit(IASTprogram iast) throws Throwable {
		int length=iast.getFunctionDefinitions().length;
		IASTfunctionDefinition[] function=new  IASTfunctionDefinition[length];
		for(int i=0;i<length;i++) {
			function[i]=iast.getFunctionDefinitions()[i];
		}

		return f.newProgram(function, iast.getBody().accept(this, null));
	}

	
	@Override
	public IASTexpression visit(IASTassignment iast, Void data) throws Throwable {
		
		return f.newAssignment(iast.getVariable(), iast.getExpression().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTloop iast, Void data) throws Throwable {
		return f.newLoop(iast.getCondition().accept(this, data), iast.getBody().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTalternative iast, Void data) throws Throwable {
		IASTexpression consequence =iast.getConsequence().accept(this, data);
		IASTexpression condition = iast.getCondition().accept(this, data);
		
		return iast.isTernary() ? f.newAlternative(condition, consequence,iast.getAlternant().accept(this, data)): f.newAlternative(condition, consequence,null);
	}

	@Override
	public IASTexpression visit(IASTbinaryOperation iast, Void data) throws Throwable {
		return f.newBinaryOperation(iast.getOperator(), iast.getLeftOperand().accept(this, data), iast.getRightOperand().accept(this, data))
			;
	}

	@Override
	public IASTexpression visit(IASTblock iast, Void data) throws Throwable {
		int length=iast.getBindings().length;
		IASTblock.IASTbinding[] binding=new ASTbinding[length]; 
		for (int i=0;i<length;i++) {
			binding[i] =f.newBinding(iast.getBindings()[i].getVariable(),iast.getBindings()[i].getInitialisation().accept(this, data));
		}
		return f.newBlock(binding, iast.getBody().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTboolean iast, Void data) throws Throwable {
		return f.newBooleanConstant(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTfloat iast, Void data) throws Throwable {
		return f.newFloatConstant(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTinteger iast, Void data) throws Throwable {
		
		return f.newIntegerConstant(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTinvocation iast, Void data) throws Throwable {
		int length=iast.getArguments().length;
		IASTexpression [] arguments=new IASTexpression[length];
		for (int i=0;i<length;i++) {
			arguments[i]=iast.getArguments()[i].accept(this, data);
		}
		return f.newInvocation(iast.getFunction().accept(this, data), arguments);
	}

	@Override
	public IASTexpression visit(IASTsequence iast, Void data) throws Throwable {
		int  length=iast.getExpressions().length;
		IASTexpression [] arguments=new IASTexpression[length];
		for (int i=0;i<length;i++) {
			arguments[i]=iast.getExpressions()[i].accept(this, data);
		}
		return f.newSequence(arguments);
	}

	@Override
	public IASTexpression visit(IASTstring iast, Void data) throws Throwable {

		return f.newStringConstant(iast.getDescription());
	}

	@Override
	public IASTexpression visit(IASTunaryOperation iast, Void data) throws Throwable {
		return f.newUnaryOperation(iast.getOperator(), iast.getOperand().accept(this, data));
	}

	@Override
	public IASTexpression visit(IASTvariable iast, Void data) throws Throwable {
		
		return f.newVariable(iast.getName());
	}

	@Override
	public IASTexpression visit(IASTunless iast, Void data) throws Throwable {
		return f.newAlternative(iast.getCondition().accept(this, data),f.newBooleanConstant("false"),iast.getConsequence().accept(this, data));
	}

}
