package pex.core.visitors;

import pex.core.*;
import pex.core.expression.*;

public abstract class Visitor {
	// Overloaders
	public void visit(Program obj) {
		visitProgram(obj);
	}

	// Specifications
	public abstract void visitProgram(Program program);
}
