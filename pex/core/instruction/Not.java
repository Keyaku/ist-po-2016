package pex.core.instruction;

// FIXME: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Not extends UnaryExpression {
	public Not(Expression arg) {
		super(arg);
	}

	public String getAsText() {
		return "Not(" + getArgument().getAsText() + ")";
	}

	public Literal evaluate() {
		// FIXME
		return "";
	}
}
