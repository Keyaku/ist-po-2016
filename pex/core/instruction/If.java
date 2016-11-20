package pex.core.instruction;

// FIXME: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class If extends TernaryExpression {
	public If(Expression arg1, Expression arg2, Expression arg3) {
		super(arg1, arg2, arg3);
	}

	public String getAsText() {
		return "If(" +
			getFirstArgument().getAsText()  + ", " +
			getSecondArgument().getAsText() + ", " +
			getThirdArgument().getAsText()  +
			")";
	}

	public Literal evaluate() {
		// FIXME
		return "";
	}
}
