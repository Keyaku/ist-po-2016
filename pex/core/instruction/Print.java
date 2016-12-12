package pex.core.instruction;

import java.util.List;
import java.lang.StringBuilder;

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
	 	StringBuilder str = new StringBuilder();

		for (Expression exp : getArguments()) {
			retval = exp.evaluate();
			if (retval == null) {
				continue;
			}
			// FIXME: This kind of specification is highly unappreciated
			if (retval instanceof StringLiteral) {
				StringLiteral lit = (StringLiteral) retval;
				str.append(lit.stringValue());
			} else {
				str.append(retval.getAsText());
			}
		}

		_io.println(str.toString());
		return retval;
	}
}
