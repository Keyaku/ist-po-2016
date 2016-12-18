package pex.core.instruction;

import pex.core.expression.*;
import pex.core.visitors.*;

public class Nop extends CompositeExpression {
	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getInstructionName() {
		return "nop";
	}

	public Literal evaluate() {
		return new IntegerLiteral(0);
	}
}
