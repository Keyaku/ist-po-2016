package pex.core.instruction;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Neg extends UnaryExpression {
	public Neg(Expression arg) {
		super(arg);
	}

	public String getAsText() {
		return "(neg " + getArgument().getAsText() + ")";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
