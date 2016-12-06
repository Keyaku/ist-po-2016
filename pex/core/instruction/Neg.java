package pex.core.instruction;


import pex.core.expression.*;


public class Neg extends UnaryExpression {
	public Neg(Expression arg) {
		super(arg);
	}

	public String getInstructionName() {
		return "neg";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
