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
		IntegerLiteral lit1 = (IntegerLiteral) getFirstArgument().evaluate();

		if (lit1.intValue() != 0) {
			IntegerLiteral lit2 = (IntegerLiteral) getSecondArgument().evaluate();
			if (lit2.intValue() != 0) {
				return new IntegerLiteral(1);
			}
		}

		return new IntegerLiteral(0);
	}
}
