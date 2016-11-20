package pex.core.function;

import pex.AppIO;

public class Print extends VariadicExpression{
	private AppIO _io;

	public Print(List<Expression> args, AppIO io) {
		super(args);
		_io = io;
	}

	public String getAsText() {
		String result = "Print(";
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
