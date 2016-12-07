package pex.core.instruction;

import java.util.List;

import pex.AppIO;
import pex.core.expression.*;

public class Print extends VariadicExpression {
	private AppIO _io;

	public Print(List<Expression> args, AppIO io) {
		super(args);
		_io = io;
	}

	public String getInstructionName() {
		return "print";
	}

	public Literal evaluate() {
		Literal retval = null;
		for (Expression exp : getArguments()) {
			retval = exp.evaluate();
			StringLiteral lit = (StringLiteral) retval;
			_io.println(lit.stringValue());
		}
		return retval;
	}
}
