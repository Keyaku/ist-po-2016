package pex.core.instruction;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Ge extends BinaryExpression {
	public Ge(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getAsText() {
		return "(ge " +
			getFirstArgument().getAsText()  + " " +
			getSecondArgument().getAsText() +
			")";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
