package pex.core.instruction;

// FIXME: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Neg extends UnaryExpression {
	public Neg(Expression arg) {
		super(arg);
	}

	public String getAsText() {
		return "Neg(" + getArgument().getAsText() + ")";
	}

	public String evaluate() {
		// FIXME
		return "";
	}
}
