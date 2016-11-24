package pex.core;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

import pex.AppIO;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;
import pex.core.expression.Identifier;
import pex.core.expression.Literal;

public class Interpreter implements Serializable {
	private String _filename;
	private AppIO _io;
	private Map<String, Program> _progs = new HashMap<String, Program>();

	public Interpreter(AppIO appio) {
		_io = appio;
	}

	public void setIdentifierValue(Identifier id, Literal value) {
		// FIXME: what do we do here?
	}

	public Literal getIdentifierValue(Identifier id) {
		return id.evaluate();
	}

	public void addProgram(Program p) {
		if (_progs.containsKey(p.getName())) {
			_progs.remove(p.getName());
		}
		_progs.put(p.getName(), p);
	}

	public Program getProgram(String name) {
		return _progs.get(name);
	}

	public void setFilename(String value) {
		_filename = value;
	}

	public String getFilename() {
		return _filename;
	}

	public AppIO getAppIO() {
		return _io;
	}
}
