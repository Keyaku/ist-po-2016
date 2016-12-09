package pex.core.visitors;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import pex.core.*;
import pex.core.expression.*;
import pex.core.instruction.*;

public class IdentifierVisitor implements Visitor {
	private List<Identifier> _ids = new ArrayList<Identifier>();

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
	}
	public void visit(VariadicExpression obj) {
		for (Expression exp : obj.getArguments()) {
			exp.accept(this);
		}
	}
	public void visit(Set obj) {
		Identifier id = (Identifier) obj.getFirstArgument();
		id.accept(this);
	}

	public List<Identifier> getAllIdentifiers() {
		return _ids;
	}
}
