package pex.core.expression;

/**
 * Class for representing a syntax error problem: expression does not follow syntax.
 */
public class InvalidIdentifierException extends Exception {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 201612181309L;

    /** The number of the line containing the invalid expression. */
    private String _name;

    /**
     * @param name identifier name
     */
    public InvalidIdentifierException(String name) {
        super("Invalid identifier name " + name);
        _name = name;
    }

	/**
	* @param description
	* @param cause
	*/
	public InvalidIdentifierException(String name, Exception cause) {
	    super("Invalid identifier name " + name, cause);
	}

	/**
	* @param cause
	*/
	public InvalidIdentifierException(Exception cause) {
		super(cause);
	}

    /**
     * @return identifier name
     */
    public String getName() {
        return _name;
    }

}
