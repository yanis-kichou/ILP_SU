package com.paracamplus.ilp1.ilp1tme2.ex1;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfactory;
import com.paracamplus.ilp1.interfaces.IASTvariable;

import antlr4.ILPMLgrammar1tme2Listener;
import antlr4.ILPMLgrammar1tme2Parser.ExprContext;
import antlr4.ILPMLgrammar1tme2Parser.AffectationContext;
import antlr4.ILPMLgrammar1tme2Parser.AlternativeContext;
import antlr4.ILPMLgrammar1tme2Parser.BinaryContext;
import antlr4.ILPMLgrammar1tme2Parser.BindingContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstFalseContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstFloatContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstIntegerContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstStringContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstTrueContext;
import antlr4.ILPMLgrammar1tme2Parser.FunctionContext;
import antlr4.ILPMLgrammar1tme2Parser.InvocationContext;
import antlr4.ILPMLgrammar1tme2Parser.LoopContext;
import antlr4.ILPMLgrammar1tme2Parser.ProgContext;
import antlr4.ILPMLgrammar1tme2Parser.SequenceContext;
import antlr4.ILPMLgrammar1tme2Parser.UnaryContext;
import antlr4.ILPMLgrammar1tme2Parser.VariableContext;



import java.util.List;
public class ILPMLListener implements ILPMLgrammar1tme2Listener {
	
	protected IASTfactory factory;
	public ILPMLListener(IASTfactory factory) {
		super();
		this.factory = factory;		
	}
	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterBinding(BindingContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitBinding(BindingContext ctx) {
		ctx.node = factory.newBlock(
				toBindings(ctx.vars, ctx.vals),
				ctx.body.node);
		
	}

	@Override
	public void enterLoop(LoopContext ctx) {
		System.out.println("entre while ");
		
	}

	@Override
	public void exitLoop(LoopContext ctx) {
		System.out.println(("exit while"));
	}

	@Override
	public void enterVariable(VariableContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitVariable(VariableContext ctx) {
		ctx.node = factory.newVariable(ctx.getText());
		
	}

	@Override
	public void enterAlternative(AlternativeContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitAlternative(AlternativeContext ctx) {
		ctx.node = factory.newAlternative(
				ctx.condition.node, 
				ctx.consequence.node, 
				(ctx.alternant == null ? null : ctx.alternant.node));
		
	}

	@Override
	public void enterInvocation(InvocationContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitInvocation(InvocationContext ctx) {
			ctx.node = factory.newInvocation(
					ctx.fun.node, 
					toExpressions(ctx.args));
	}

	@Override
	public void enterConstFloat(ConstFloatContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstFloat(ConstFloatContext ctx) {
		ctx.node = factory.newFloatConstant(ctx.floatConst.getText());		
	}

	@Override
	public void enterSequence(SequenceContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSequence(SequenceContext ctx) {
		ctx.node = factory.newSequence(toExpressions(ctx.exprs));
		
	}

	@Override
	public void enterConstFalse(ConstFalseContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstFalse(ConstFalseContext ctx) {
		ctx.node = factory.newBooleanConstant("false");
		
	}

	@Override
	public void enterProg(ProgContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitProg(ProgContext ctx) {
		IASTexpression e = factory.newSequence(toExpressions(ctx.exprs));
		ctx.node = factory.newProgram(e);
		
	}

	@Override
	public void enterUnary(UnaryContext ctx) {
		// TODO Auto-generated method stubctx.node = factory.newUnaryOperation(
	
		
	}

	@Override
	public void exitUnary(UnaryContext ctx) {
		ctx.node = factory.newUnaryOperation(
				factory.newOperator(ctx.op.getText()),
				ctx.arg.node);
		
	}

	@Override
	public void enterFunction(FunctionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitFunction(FunctionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterConstTrue(ConstTrueContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstTrue(ConstTrueContext ctx) {
		ctx.node = factory.newBooleanConstant("true");
		
	}

	@Override
	public void enterConstInteger(ConstIntegerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstInteger(ConstIntegerContext ctx) {
		ctx.node = factory.newIntegerConstant(ctx.intConst.getText());

		
	}

	@Override
	public void enterAffectation(AffectationContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitAffectation(AffectationContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterConstString(ConstStringContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstString(ConstStringContext ctx) {
		/*
		 * On enlève le " initial et final, et on interprète les codes
		 * d'échapement \n, \r, \t, \"
		 */
		String s = ctx.getText();
		StringBuilder buf = new StringBuilder();
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == '\\' && i < s.length() - 2) {
				switch (s.charAt(i+1)) {
				case 'n': buf.append('\n'); i++; break;
				case 'r': buf.append('\r'); i++; break;
				case 't': buf.append('\t'); i++; break;
				case '"': buf.append('\"'); i++; break;
				default: buf.append(s.charAt(i));
				}
			}
			else buf.append(s.charAt(i));
		}
		ctx.node = factory.newStringConstant(buf.toString());
		
	}

	@Override
	public void enterBinary(BinaryContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitBinary(BinaryContext ctx) {
		ctx.node = factory.newBinaryOperation(
				factory.newOperator(ctx.op.getText()),
				ctx.arg1.node,
				ctx.arg2.node);	
		
	}
	
	protected IASTexpression[] toExpressions(
			List<ExprContext> ctxs) {
		if (ctxs == null) return new IASTexpression[0];
		IASTexpression[] r = new IASTexpression[ctxs.size()];
		int pos = 0;
		for (ExprContext e : ctxs) {
			r[pos++] = e.node;
		}
		return r;
	}
	protected IASTvariable[] toVariables(
			List<Token> vars, boolean addSelf) {
		if (vars == null) return new IASTvariable[0];
		IASTvariable[] r = new IASTvariable[vars.size() + (addSelf ? 1 : 0)];
		int pos = 0;
		if (addSelf) {
			// Les déclarations de méthodes ont une variable "self" implicite
			r[pos++] = factory.newVariable("self");
		}
		for (Token v : vars) {
			r[pos++] = factory.newVariable(v.getText());
		}
		return r;
	}
	protected String[] toStrings(List<Token> vars) {
		if (vars == null) return new String[0];
		String[] r = new String[vars.size()];
		int pos = 0;
		for (Token v : vars) {
			r[pos++] = v.getText();
		}
		return r;
	}
	protected IASTblock.IASTbinding[] toBindings(
			List<Token> vars, 
			List<ExprContext> exprs) {
		if (vars == null) return new IASTblock.IASTbinding[0];
		/* par construction, vars et ctxs ont la même taille */
		assert(vars.size() == exprs.size());
		IASTblock.IASTbinding[] r = new IASTblock.IASTbinding[exprs.size()];
		int pos = 0;
		for (Token v : vars) {
			r[pos] = factory.newBinding(
					factory.newVariable(v.getText()),
					exprs.get(pos).node
					);
			pos++;
		}
		return r;			
	}

}
