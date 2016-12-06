package pex.core.expression;

public abstract class CompositeExpression extends Expression {
	/**
	** An expression has a unique operator
	** @return The operator assigned to the expression
	*/
	public abstract String getInstructionName();

	public String getAsText() {
		return "(" + getInstructionName() + ")";
	}
}
