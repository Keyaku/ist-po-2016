package pex.core;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
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

	// ------------- Visitor code -------------
	// TODO: Document this method
	public Iterator<Program> getChildIterator() {
		return _progs.values().iterator();
	}
	// ----------------------------------------

	// TODO: Document this method
	public void setIdentifierValue(Identifier id, Literal value) {
		_ids.put(id, value);
	}

	// TODO: Document this method
	public Literal getIdentifierValue(Identifier id) {
		return _ids.get(id);
	}

	// TODO: Document this method
	public void addProgram(Program p) {
		p.setInterpreter(this);
		if (_progs.containsKey(p.getName())) {
			_progs.remove(p.getName());
		}
		_progs.put(p.getName(), p);
	}

	// TODO: Document this method
	public Program removeProgram(Program p) {
		return _progs.remove(p.getName());
	}

	// TODO: Document this method
	public Program getProgram(String name) {
		return _progs.get(name);
	}

	// TODO: Document this method
	public void setFilename(String value) {
		_filename = value;
	}

	// TODO: Document this method
	public String getFilename() {
		return _filename;
	}

	// TODO: Document this method
	public AppIO getAppIO() {
		return _io;
	}
}
