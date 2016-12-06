package pex.core.instruction;


import pex.core.expression.*;


public class Eq extends BinaryExpression {
	public Eq(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "eq";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
