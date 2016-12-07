package pex.core.instruction;

import pex.parser.NewParser;
import pex.core.Program;
import pex.core.expression.*;


public class Call extends UnaryExpression {
	private Program _program;

	public Call(Expression arg) {
		super(arg);
	}

	public String getInstructionName() {
		return "call";
	}

	public Literal evaluate() {
		StringLiteral lit = (StringLiteral) getArgument();
		String name = lit.stringValue();
		Program p = _program.getInterpreter().getProgram(name);
		return p.execute();
	}
}
