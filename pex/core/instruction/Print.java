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
		for (Expression exp : getArguments()) {
			StringLiteral lit = (StringLiteral) exp.evaluate();
			_io.println(lit.stringValue());
		}
		return getArguments().get(getArguments().size() - 1).evaluate();
	}
}
