package pex.core.instruction;

import pex.core.Program;

// FIXME: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Call extends UnaryExpression {
	private Program _prog;

	public Call(Expression arg) {
		super(arg);
	}

	public String getAsText() {
		return "Call(" + getArgument().getAsText() + ")";
	}

	public String evaluate() {
		// FIXME
		return "";
	}
}
