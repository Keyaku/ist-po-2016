package pex.parser;

/**
 * Class for representing a syntax error problem: expression does not follow syntax.
 */
public class InvalidIdentifierException extends ParserException {
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
     * @return identifier name
     */
    public String getName() {
        return _name;
    }

}
