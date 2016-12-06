package pex.core.instruction;

import pex.core.expression.Literal;
import pex.core.expression.CompositeExpression;
import pex.AppIO;

public class ReadS extends CompositeExpression {
	private AppIO _io; // FIXME: what to do with this?

	public String getInstructionName() {
		return "reads";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
