package pex.core.expression;

public abstract class TernaryExpression extends CompositeExpression {
	private Expression _arg1, _arg2;

	/**
	** TernaryExpression constructor, abstract enough to gather 3 arguments.
	*/
	public TernaryExpression(Expression arg1, Expression arg2, Expression arg3) {
		_arg1 = arg1;
		_arg2 = arg2;
		_arg3 = arg3;
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

	/**
	** Gets the third instanced argument.
	** @return The argument issued during creation.
	*/
	public Expression getThirdArgument() {
		return _arg3;
	}
}
