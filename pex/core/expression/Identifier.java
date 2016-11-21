package pex.core.expression;

public class Identifier extends Expression {
	private String _name;

	public Identifier(String value) {
		_name = value;
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
		// FIXME
		return null;
	}
}
