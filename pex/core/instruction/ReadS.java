package pex.core.instruction;

import pex.AppIO;

import pex.core.expression.*;

public class ReadS extends CompositeExpression {
	private AppIO _io;

	public ReadS() {
	}

	public String getInstructionName() {
		return "reads";
	}

	public Literal evaluate() {
		String input = _io.readString("", "");
		return new StringLiteral(input);
	}
}
