package pex.core.expression;

import pex.core.visitors.*;
import pex.core.Program;

public class Identifier extends Expression implements Comparable<Identifier>, Visitable {
	private String _name;
	private Program _parent;

	public Identifier(String name, Program program) throws InvalidIdentifierException {
		if (!isNameValid(name)) {
			throw new InvalidIdentifierException(name);
		}
		_name = name;
		_parent = program;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	** Returns the literal as text
	** @return Value as a String
	*/
	public String getAsText() {
		return _name;
	}

	/**
	** Evaluates this Expression
	** @return Value of the Literal
	*/
	public Literal evaluate() {
		Literal retval = _parent.getIdentifierValue(this);
		if (retval == null) {
			retval = new IntegerLiteral(0);
		}
		return retval;
	}

	public int compareTo(Identifier i) {
		return getAsText().compareTo(i.getAsText());
	}

	private Boolean isNameValid(String name) {
		if (Character.isDigit(name.charAt(0))) {
			return false;
		}
		return name.length() > 0;
	}
}
