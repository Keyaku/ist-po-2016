package pex.core.function;

public class Seq extends VariadicExpression {
	public Seq(List<Expression> args) {
		super(args);
	}

	public String getAsText() {
		String result = "Seq(";
		for (Expression exp : getArguments()) {
			result += exp.getAsText() + ", ";
		}
		return result + ")";
	}

	public String evaluate() {
		// FIXME
		return "";
	}
}
