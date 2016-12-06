package pex.core.instruction;

import java.util.List;

// TODO: remove these if we're to put Expression right under core/
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
