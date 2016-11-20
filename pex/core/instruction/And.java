package pex.core.instruction;

// FIXME: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class And extends BinaryExpression {
	public And(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getAsText() {
		return "And(" +
			getFirstArgument().getAsText()  + ", " +
			getSecondArgument().getAsText() +
			")";
	}

	public String evaluate() {
		// FIXME
		return "";
	}
}
