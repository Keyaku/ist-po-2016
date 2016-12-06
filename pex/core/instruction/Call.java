package pex.core.instruction;

import pex.core.Program;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Call extends UnaryExpression {
	private Program _prog;

	public Call(Expression arg) {
		super(arg);
	}

	public String getAsText() {
		return "(call " + getArgument().getAsText() + ")";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
