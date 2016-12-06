package pex.core.instruction;

import pex.core.Program;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;

public class Set extends BinaryExpression {
	private Program _prog;

	public Set(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getAsText() {
		return "(set " +
			getFirstArgument().getAsText()  + " " +
			getSecondArgument().getAsText() +
			")";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
