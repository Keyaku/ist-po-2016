package pex.core.instruction;


import pex.core.expression.*;


public class Add extends BinaryExpression {
	public Add(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "add";
	}

	public Literal evaluate() {
		IntegerLiteral lit1 = (IntegerLiteral) getFirstArgument();
		IntegerLiteral lit2 = (IntegerLiteral) getSecondArgument();
		int result = lit1.intValue() + lit2.intValue();
		return new IntegerLiteral(result);
	}
}
