package pex.core.function;

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
