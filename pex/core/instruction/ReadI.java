package pex.core.instruction;

import pex.core.expression.Literal;
import pex.core.expression.CompositeExpression;
import pex.AppIO;

public class ReadI extends CompositeExpression {
	private AppIO _io; // FIXME: what to do with this?

	public String getInstructionName() {
		return "readi";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
