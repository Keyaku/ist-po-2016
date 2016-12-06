package pex.core.instruction;

import pex.core.Program;


import pex.core.expression.*;

public class Set extends BinaryExpression {
	private Program _prog;

	public Set(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "set";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
