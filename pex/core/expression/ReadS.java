package pex.core.expression;

import pex.AppIO;

public class ReadS extends CompositeExpression {
	private AppIO _io;

	public String getAsText() {
		return "ReadS()";
	}

	public Literal evaluate() {
		// FIXME
		return "";
	}
}
