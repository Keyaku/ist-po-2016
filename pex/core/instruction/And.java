package pex.core.instruction;


import pex.core.expression.*;


public class And extends BinaryExpression {
	public And(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "and";
	}

	public Literal evaluate() {
		IntegerLiteral lit1 = (IntegerLiteral) getFirstArgument();
		IntegerLiteral lit2 = (IntegerLiteral) getSecondArgument();

		if (lit1.intValue() == 0 || lit2.intValue() == 0) {
			return new IntegerLiteral(0);
		}

		return new IntegerLiteral(1);
	}
}
