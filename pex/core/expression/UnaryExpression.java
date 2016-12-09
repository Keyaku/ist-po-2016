package pex.core.expression;

import pex.core.visitors.*;

public abstract class UnaryExpression extends CompositeExpression implements Visitable {
	private Expression _arg;

	/**
	** UnaryExpression constructor, abstract enough to gather 1 argument.
	*/
	public UnaryExpression(Expression arg) {
		_arg = arg;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	** Gets the only argument.
	** @return The argument issued during creation.
	*/
	public Expression getArgument() {
		return _arg;
	}

	public String getAsText() {
		return "(" + getInstructionName() + " " + getArgument().getAsText() + ")";
	}
}
