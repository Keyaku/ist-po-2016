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
		// FIXME
		return null;
	}
}
