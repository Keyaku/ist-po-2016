package pex.core.instruction;

import pex.core.Program;


import pex.core.expression.*;


public class Call extends UnaryExpression {
	private Program _prog;

	public Call(Expression arg) {
		super(arg);
	}

	public String getInstructionName() {
		return "call";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
