package pex.core.expression;

import java.util.List;

public abstract class VariadicExpression extends CompositeExpression {
	private List<Expression> _args;

	/**
	** VariadicExpression constructor, gathers a list of virtually unlimited arguments.
	*/
	public VariadicExpression(List<Expression> args) {
		_args = args;
	}

	/**
	** Gets all arguments in the form of a List.
	** @return List of arguments issued during creation.
	*/
	public List<Expression> getArguments() {
		return _args;
	}

	public String getAsText() {
		String result = "";
		for (Expression exp : _args) {
			result += " " + exp.getAsText();
		}
		return result;
	}
}
