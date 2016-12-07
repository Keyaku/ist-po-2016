package pex.core;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.Serializable;

import pex.AppIO;


import pex.core.expression.*;
import pex.core.expression.Identifier;
import pex.core.expression.Literal;

public class Interpreter implements Serializable {
	private String _filename;
	private AppIO _io;
	private Map<String, Program> _progs = new HashMap<String, Program>();
	private Map<Identifier, Literal> _ids = new TreeMap<Identifier, Literal>();

	public Interpreter(AppIO appio) {
		_io = appio;
	}

	public void setIdentifierValue(Identifier id, Literal value) {
		_ids.put(id, value);
	}

	public Literal getIdentifierValue(Identifier id) {
		return _ids.get(id);
	}

	public void addProgram(Program p) {
		p.setInterpreter(this);
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
