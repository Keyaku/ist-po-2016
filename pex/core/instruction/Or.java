package pex.core.instruction;


import pex.core.expression.*;


public class Or extends BinaryExpression {
	public Or(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "or";
	}

	public Literal evaluate() {
		IntegerLiteral lit1 = (IntegerLiteral) getFirstArgument();
		IntegerLiteral lit2 = (IntegerLiteral) getSecondArgument();

		if (lit1.intValue() == 1 || lit2.intValue() == 1) {
			return new IntegerLiteral(1);
		}

		return new IntegerLiteral(0);
	}
}
