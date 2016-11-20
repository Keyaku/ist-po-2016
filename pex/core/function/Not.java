package pex.core.function;

public class Not extends UnaryExpression {
	public Not(Expression arg) {
		super(arg);
	}

	public String getAsText() {
		return "Not(" + getArgument().getAsText() + ")";
	}

	public String evaluate() {
		// FIXME
		return "";
	}
}
