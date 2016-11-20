package pex.core.expression;

public abstract class UnaryExpression extends CompositeExpression {
	private Expression _arg;

	/**
	** UnaryExpression constructor, abstract enough to gather 1 argument.
	*/
	public UnaryExpression(Expression arg) {
		_arg = arg;
	}

	/**
	** Gets the only argument.
	** @return The argument issued during creation.
	*/
	public Expression getArgument() {
		return _arg;
	}
}
