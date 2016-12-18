package pex.core.instruction;

import java.lang.Math;

import pex.core.expression.*;


public class Sqrt extends UnaryExpression {
	public Sqrt(Expression arg) {
		super(arg);
	}

	public String getInstructionName() {
		return "sqrt";
	}

	public Literal evaluate() {
		IntegerLiteral lit = (IntegerLiteral) getArgument().evaluate();
		int value = (int) Math.sqrt((int) lit.intValue());
		return new IntegerLiteral(value);
	}
}
