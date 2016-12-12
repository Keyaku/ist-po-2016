package pex.core.expression;

public class IntegerLiteral extends Literal {
	private int _value = 0;

	/**
	** Constructor of a Literal containing an integer.
	*/
	public IntegerLiteral(int value) {
		_value = value;
	}

	public String getAsText() {
		return Integer.toString(_value);
	}

	/**
	** Returns literal value.
	** @return integer literal
	*/
	public int intValue() {
		return _value;
	}

	public String stringValue() {
		return getAsText();
	}
}
