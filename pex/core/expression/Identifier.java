package pex.core.expression;

import pex.core.visitors.*;
import pex.core.Program;

public class Identifier extends Expression implements Comparable<Identifier>, Visitable {
	private String _name;
	private Program _parent;

	public Identifier(String name, Program program) {
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

	private Boolean isNameValid() {
		if (Character.isDigit(_name.charAt(0))) {
			return false;
		}
		return _name.length() > 0;
	}
}
