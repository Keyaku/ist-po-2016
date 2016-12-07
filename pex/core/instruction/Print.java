package pex.core.instruction;

import java.util.List;

import pex.AppIO;


import pex.core.expression.*;

public class Print extends VariadicExpression {
	private AppIO _io;

	public Print(List<Expression> args) {
		super(args);
	}

	public String getInstructionName() {
		return "print";
	}

	public Literal evaluate() {
		for (Expression exp : getArguments()) {
			_io.println(exp.getAsText());
		}
		return getArguments().get(getArguments().size() - 1).evaluate();
	}
}
