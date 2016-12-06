package pex.core.instruction;


import pex.core.expression.*;


public class Ne extends BinaryExpression {
	public Ne(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "ne";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
