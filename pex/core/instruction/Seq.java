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
		Literal retval = null;
		for (Expression arg : getArguments()) {
			retval = arg.evaluate();
		}
		return retval;
	}
}
