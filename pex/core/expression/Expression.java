package pex.core.expression;

public abstract class Expression {
	/**
	** Returns the literal as text
	** @return Value as a String
	*/
	public abstract String getAsText();

	/**
	** Evaluates this Expression
	** @return Value of the Literal
	*/
	public abstract Literal evaluate();
}
