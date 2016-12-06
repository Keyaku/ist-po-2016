package pex.core.instruction;


import pex.core.expression.*;


public class Not extends UnaryExpression {
	public Not(Expression arg) {
		super(arg);
	}

	public String getInstructionName() {
		return "not";
	}

	public Literal evaluate() {
		IntegerLiteral lit = (IntegerLiteral) getArgument();
		return lit.intValue() == 0 ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}
}
