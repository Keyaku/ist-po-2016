package pex.core.expression;

import java.io.Serializable;

import pex.core.visitors.*;

public abstract class Expression implements Serializable, Visitable {

	public abstract void accept(Visitor v);

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
