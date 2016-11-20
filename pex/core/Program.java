package pex.core;

import java.util.List;
import java.util.ArrayList;

import pex.AppIO;

// FIXME: remove these if we're to put Expression right under core/
import pex.core.expression.*;
import pex.core.expression.Identifier;
import pex.core.expression.Literal;

public class Program {
	private String _name = "";
	private List<Expression> _exps;

	public Program(String name) {
		_name = name;
		_exps = new ArrayList<Expression>();
	}

	public void add(int idx, Expression exp) {
		_exps.add(idx, exp);
	}
	public void setIdentifierValue(Identifier id, Literal value) {
		// FIXME: what do we do here?
	}
	public Literal getIdentifierValue(Identifier id) {
		return id.evaluate();
	}
	public Literal execute() {
		// FIXME: iterate the List of Expressions, evaluate each one and return
		// the final Literal
	}
	public String getAsText() {
		String result = _name + ":\n\"\"\"";
		for (Expression exp : _exps) {
			result += exp.getAsText() + "\n";
		}
		return result + "\n\"\"\"";
	}
}
