package pex.core.expression;

import pex.core.Program;

public class Identifier extends Expression implements Comparable<Identifier> {
	private String _name;
	private Program _parent;

	public Identifier(String name, Program program) {
		_name = name;
		_parent = program;
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
		return _parent.getIdentifierValue(this);
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
