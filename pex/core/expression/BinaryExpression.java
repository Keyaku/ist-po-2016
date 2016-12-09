package pex.core.expression;

import pex.core.visitors.*;

public abstract class BinaryExpression extends CompositeExpression implements Visitable {
	private Expression _arg1, _arg2;

	/**
	** BinaryExpression constructor, abstract enough to gather 2 arguments.
	*/
	public BinaryExpression(Expression arg1, Expression arg2) {
		_arg1 = arg1;
		_arg2 = arg2;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	** Gets the first instanced argument.
	** @return The argument issued during creation.
	*/
	public Expression getFirstArgument() {
		return _arg1;
	}

	/**
	** Gets the second instanced argument.
	** @return The argument issued during creation.
	*/
	public Expression getSecondArgument() {
		return _arg2;
	}

	public String getAsText() {
		return "(" + getInstructionName() + " " +
			getFirstArgument().getAsText()  + " " +
			getSecondArgument().getAsText() +
			")";
	}
}
