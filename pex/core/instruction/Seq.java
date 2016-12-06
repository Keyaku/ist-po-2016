package pex.core.instruction;

import java.util.List;


import pex.core.expression.*;


public class Seq extends VariadicExpression {
	public Seq(List<Expression> args) {
		super(args);
	}

	public String getInstructionName() {
		return "seq";
	}

	public Literal evaluate() {
		for (Expression arg : getArguments()) {
			arg.evaluate();
		}
		return getArguments().get(getArguments().size() - 1).evaluate();
	}
}
