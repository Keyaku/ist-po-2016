package pex.core.instruction;

import pex.core.Program;


import pex.core.expression.*;

public class Set extends BinaryExpression {
	private Program _prog;

	public Set(Expression arg1, Expression arg2, Program prog) {
		super(arg1, arg2);
		_prog = prog;
	}

	public String getInstructionName() {
		return "set";
	}

	public Literal evaluate() {
		Identifier id = (Identifier) getFirstArgument();
		Literal lit = getSecondArgument().evaluate();
		_prog.setIdentifierValue(id, lit);
		return lit;
	}
}
