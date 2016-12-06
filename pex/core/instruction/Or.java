package pex.core.instruction;


import pex.core.expression.*;


public class Or extends BinaryExpression {
	public Or(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "or";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
