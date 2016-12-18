package pex.core.instruction;

import pex.core.expression.*;


public class Shift extends TernaryExpression {
	public Shift(Expression arg1, Expression arg2, Expression arg3) {
		super(arg1, arg2, arg3);
	}

	public String getInstructionName() {
		return "shift";
	}

	public Literal evaluate() {
		IntegerLiteral left = getFirstArgument().evaluate();
		IntegerLiteral number = getSecondArgument().evaluate();
		IntegerLiteral amount = getThirdArgument().evaluate();

		int retval = number.intValue();
		if (left.intValue() == 0) { // if shifting left
			retval <<= amount.intValue()
		} else {
			retval >>= amount.intValue()
		}

		return new IntegerLiteral(reval);
	}
}
