package pex.core.instruction;


import pex.core.expression.*;


public class Ne extends BinaryExpression {
	public Ne(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "ne";
	}

	public Literal evaluate() {
		IntegerLiteral lit1 = (IntegerLiteral) getFirstArgument();
		IntegerLiteral lit2 = (IntegerLiteral) getSecondArgument();
		return lit1.intValue() != lit2.intValue() ? new IntegerLiteral(1) : new IntegerLiteral(0);
	}
}
