package pex.core;

import java.util.List;

public class Interpreter {
	private AppIO _io;
	private List<Program> _progs;

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
		_progs.add(p);
	}

	public Program getProgram(String name) {
		// FIXME: find the program within _progs by `name`
		for (Program p : _progs) {
			if (p.getName() == name) {
				return p;
			}
		}
		return NULL;
	}
	
	public AppIO getAppIO() {
		return _io;
	}
}
