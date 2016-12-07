package pex.core.instruction;


import pex.core.expression.*;


public class While extends BinaryExpression {
	public While(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getInstructionName() {
		return "while";
	}

	public Literal evaluate() {
		IntegerLiteral cond = (IntegerLiteral) getFirstArgument().evaluate();
		Literal loopExp = getSecondArgument().evaluate();

		while (cond.intValue() != 0) {
			loopExp.evaluate();
			cond = cond.evaluate();
		}

		return cond;
	}
}
