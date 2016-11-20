package pex.core.expression;

import pex.AppIO;

public class ReadI extends CompositeExpression {
	private AppIO _io;

	public String getAsText() {
		return "ReadI()";
	}

	public Literal evaluate() {
		// FIXME
		return "";
	}
}
