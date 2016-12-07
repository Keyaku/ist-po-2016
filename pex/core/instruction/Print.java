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
		String str = "";
		for (Expression exp : getArguments()) {
			retval = exp.evaluate();
			// FIXME: This kind of specification is highly unappreciated
			if (retval instanceof StringLiteral) {
				StringLiteral lit = (StringLiteral) retval;
				str += lit.stringValue();
			} else {
				str += retval.getAsText();
			}
		}
		_io.println(str);
		return retval;
	}
}
