package pex.core.instruction;

import pex.AppIO;

import pex.core.expression.*;
import pex.core.visitors.*;

public class ReadI extends CompositeExpression {
	private AppIO _io;

	public ReadI(AppIO io) {
		_io = io;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getInstructionName() {
		return "readi";
	}

	public Literal evaluate() {
		int input = _io.readInteger("", "");
		return new IntegerLiteral(input);
	}
}
