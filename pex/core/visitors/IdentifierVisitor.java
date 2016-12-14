package pex.core.visitors;

import java.util.TreeSet;
import java.util.Iterator;

import pex.core.*;
import pex.core.expression.*;
import pex.core.instruction.*;

public class IdentifierVisitor implements Visitor {
	private TreeSet<Identifier> _ids = new TreeSet<Identifier>();
	private TreeSet<Identifier> _initialized = new TreeSet<Identifier>();

	// Implementing visitor methods
	public void visit(Program obj) {
		Iterator<Expression> iter = obj.getChildIterator();

		while (iter.hasNext()) {
            Expression exp = iter.next();
			exp.accept(this);
        }
	}

	public void visit(ReadI obj) {
		return;
	}
	public void visit(ReadS obj) {
		return;
	}
	public void visit(Identifier obj) {
		_ids.add(obj);
	}
	public void visit(Literal obj) {
		return;
	}
	public void visit(UnaryExpression obj) {
		obj.getArgument().accept(this);
	}
	public void visit(BinaryExpression obj) {
		obj.getFirstArgument().accept(this);
		obj.getSecondArgument().accept(this);
	}
	public void visit(TernaryExpression obj) {
		obj.getFirstArgument().accept(this);
		obj.getSecondArgument().accept(this);
		obj.getThirdArgument().accept(this);
	}
	public void visit(VariadicExpression obj) {
		for (Expression exp : obj.getArguments()) {
			exp.accept(this);
		}
	}
	public void visit(Set obj) {
		Identifier id = (Identifier) obj.getFirstArgument();
		obj.getSecondArgument().accept(this);
		id.accept(this);
		_initialized.add(id);
	}

	public TreeSet<Identifier> getAllIdentifiers() {
		return _ids;
	}

	public TreeSet<Identifier> getUninitializedIdentifiers() {
		TreeSet<Identifier> uninitialized = new TreeSet<Identifier>(_ids);
		uninitialized.removeAll(_initialized);
		return uninitialized;
	}
}
