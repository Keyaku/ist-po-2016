package pex.core.expression;

public class StringLiteral extends Literal {
	private String _value = "";

	/**
	** Constructor of a Literal containing a String.
	*/
	public StringLiteral(String value) {
		_value = value;
	}

	public String getAsText() {
		return "\"" + _value + "\"";
	}

	/**
	** Returns literal value.
	** @return literal
	*/
	public String stringValue() {
		return _value;
	}
}
