package pex.core.instruction;

import java.util.List;

import pex.AppIO;


import pex.core.expression.*;

public class Print extends VariadicExpression {
	private AppIO _io; // FIXME: what to do with this?

	public Print(List<Expression> args) {
		super(args);
	}

	public String getInstructionName() {
		return "print";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
