package pex.core.instruction;

import java.util.List;

import pex.AppIO;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;

public class Print extends VariadicExpression {
	private AppIO _io; // FIXME: what to do with this?

	public Print(List<Expression> args) {
		super(args);
	}

	public String getAsText() {
		return "(print" + super.getAsText() + ")";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
