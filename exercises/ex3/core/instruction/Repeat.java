package pex.core.instruction;

import java.lang.Math;

import pex.core.expression.*;


public class Repeat extends BinaryExpression {
	public Repeat(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "repeat";
	}

	public Literal evaluate() {
		IntegerLiteral max = (IntegerLiteral) getFirstArgument().evaluate();

		int i = 0;
		while (i++ < max.intValue()) {
			getSecondArgument().evaluate();
		}

		return max;
	}
}
