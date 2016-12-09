package pex.core.visitors;

import pex.core.*;
import pex.core.expression.*;
import pex.core.instruction.*;

public interface Visitor {
	// Overloaders
	public void visit(Program obj);
	public void visit(Identifier obj);
	public void visit(Literal obj);
	public void visit(ReadI obj);
	public void visit(ReadS obj);
	public void visit(UnaryExpression obj);
	public void visit(BinaryExpression obj);
	public void visit(TernaryExpression obj);
	public void visit(VariadicExpression obj);
	public void visit(Set obj);
}
