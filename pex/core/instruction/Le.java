package pex.core.instruction;

import pex.core.expression.*;


public class Le extends BinaryExpression {
	public Le(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "le";
	}

	public Literal evaluate() {
		IntegerLiteral lit1 = (IntegerLiteral) getFirstArgument().evaluate();
		IntegerLiteral lit2 = (IntegerLiteral) getSecondArgument().evaluate();
		int result = 0;

		if (lit1.intValue() <= lit2.intValue()) {
			result = 1;
		}
		return new IntegerLiteral(result);
	}
}
