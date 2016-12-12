package pex.core.expression;

import pex.core.visitors.*;

public abstract class Literal extends Expression implements Visitable {
	public void accept(Visitor v) {
		v.visit(this);
	}

	public Literal evaluate() {
		return this;
	}

	public abstract String stringValue();
}
