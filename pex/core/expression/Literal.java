package pex.core.expression;

public abstract class Literal extends Expression {
	public Literal evaluate() {
		return this;
	}
}
