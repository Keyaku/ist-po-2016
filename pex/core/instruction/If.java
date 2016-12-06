package pex.core.instruction;


import pex.core.expression.*;


public class If extends TernaryExpression {
	public If(Expression arg1, Expression arg2, Expression arg3) {
		super(arg1, arg2, arg3);
	}

	public String getInstructionName() {
		return "if";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
