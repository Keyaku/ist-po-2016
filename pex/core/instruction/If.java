package pex.core.instruction;

import pex.core.expression.*;


public class If extends TernaryExpression {
	public If(Expression arg1, Expression arg2, Expression arg3) {
		super(arg1, arg2, arg3);
	}

	public String getInstructionName() {
		return "if";
	}

	public Literal evaluate() {
		IntegerLiteral cond = (IntegerLiteral) getFirstArgument().evaluate();
		Expression ifTrue = getSecondArgument();
		Expression ifFalse = getThirdArgument();

		if (cond.intValue() != 0) { // if true
			return ifTrue.evaluate();
		}
		return ifFalse.evaluate();
	}
}
