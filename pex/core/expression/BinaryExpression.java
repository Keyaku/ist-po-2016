package pex.core.expression;

public abstract class BinaryExpression extends CompositeExpression {
	private Expression _arg1, _arg2;

	/**
	** BinaryExpression constructor, abstract enough to gather 2 arguments.
	*/
	public BinaryExpression(Expression arg1, Expression arg2) {
		_arg1 = arg1;
		_arg2 = arg2;
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
