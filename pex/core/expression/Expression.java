package pex.core.expression;

import java.io.Serializable;

public abstract class Expression implements Serializable {
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
