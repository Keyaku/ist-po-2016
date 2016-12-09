package pex.core.expression;

import java.util.List;

import pex.core.visitors.*;

public abstract class VariadicExpression extends CompositeExpression implements Visitable {
	private List<Expression> _args;

	/**
	** VariadicExpression constructor, gathers a list of virtually unlimited arguments.
	*/
	public VariadicExpression(List<Expression> args) {
		_args = args;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	** Gets all arguments in the form of a List.
	** @return List of arguments issued during creation.
	*/
	public List<Expression> getArguments() {
		return _args;
	}

	public String getAsText() {
		String result = "(" + getInstructionName();
		for (Expression exp : _args) {
			result += " " + exp.getAsText();
		}
		return result + ")";
	}
}
