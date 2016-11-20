package pex.core.expression;

public class Identifier {
	private String _name = "";

	public Identifier(String value) {
		_name = value;
	}

	/**
	** Returns the literal as text
	** @return Value as a String
	*/
	public String getAsText() {
		return "Identifier \"" + _name + "\"";
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
