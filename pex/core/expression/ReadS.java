package pex.core.expression;

import pex.AppIO;

public class ReadS extends CompositeExpression {
	private AppIO _io; // FIXME: what to do with this?

	public String getInstructionName() {
		return "reads";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
