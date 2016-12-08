package pex.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;

import pex.core.expression.*;

public class Program implements Serializable {
	private String _name = "";
	private List<Expression> _exps = new ArrayList<Expression>();
	private Interpreter _parent;

	public Program(String name) {
		_name = name;
	}

	// TODO: Document this method
	public void setInterpreter(Interpreter value) {
		_parent = value;
	}

	// TODO: Document this method
	public Interpreter getInterpreter() {
		return _parent;
	}

	// TODO: Document this method
	public String getName() {
		return _name;
	}

	// TODO: Document this method
	public void add(int idx, Expression exp) {
		_exps.add(idx, exp);
	}

	// TODO: Document this method
	public void replace(int idx, Expression exp) {
		_exps.set(idx, exp);
	}

	// TODO: Document this method
	public void set(Collection<Expression> exps) {
		_exps.clear();
		_exps.addAll(exps);
	}

	// TODO: Document this method
	public void setIdentifierValue(Identifier id, Literal value) {
		_parent.setIdentifierValue(id, value);
	}

	// TODO: Document this method
	public Literal getIdentifierValue(Identifier id) {
		return _parent.getIdentifierValue(id);
	}

	// TODO: Document this method
	public Literal execute() {
		Literal retval = null;
		for (Expression line : _exps) {
			retval = line.evaluate();
		}
		return retval;
	}

	// TODO: Document this method
	public String getAsText() {
		String result = "";
		for (Expression exp : _exps) {
			result += exp.getAsText() + "\n";
		}
		return result;
	}

	// TODO: Document this method
	public int getNumExpressions() {
		return _exps.size();
	}
}
