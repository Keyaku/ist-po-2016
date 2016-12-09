package pex.core.instruction;

import pex.AppIO;

import pex.core.expression.*;
import pex.core.visitors.*;

public class ReadS extends CompositeExpression {
	private AppIO _io;

	public ReadS(AppIO io) {
		_io = io;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getInstructionName() {
		return "reads";
	}

	public Literal evaluate() {
		String input = _io.readString("", "");
		return new StringLiteral(input);
	}
}
