package pex.core.instruction;


import pex.core.expression.*;


public class And extends BinaryExpression {
	public And(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "and";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
