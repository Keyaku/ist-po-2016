package pex.core.function;

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
