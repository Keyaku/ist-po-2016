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
		/*
		while (iter.hasNext()) {
            Expression exp = iter.next();

            if (exp instanceof Identifier) {
				Identifier id = (Identifier) exp;
				program.setIdentifierValue(id, new IntegerLiteral(0));
            }
        }
		*/
	}

	public void visit(Identifier obj) {
		_ids.add(obj);
	}
	public void visit(Literal obj) {
		return;
	}
	public void visit(UnaryExpression obj) {
		if (obj.getArgument() instanceof Set) {
			Set arg = (Set) obj.getArgument();
			arg.accept(this);
		}
	}
	public void visit(BinaryExpression obj) {
		if (obj.getFirstArgument() instanceof Set) {
			Set arg = (Set) obj.getFirstArgument();
			arg.accept(this);
		} else if (obj.getSecondArgument() instanceof Set) {
			Set arg = (Set) obj.getSecondArgument();
			arg.accept(this);
		}
	}
	public void visit(TernaryExpression obj) {
		if (obj.getFirstArgument() instanceof Set) {
			Set arg = (Set) obj.getFirstArgument();
			arg.accept(this);
		} else if (obj.getSecondArgument() instanceof Set) {
			Set arg = (Set) obj.getSecondArgument();
			arg.accept(this);
		} else if (obj.getThirdArgument() instanceof Set) {
			Set arg = (Set) obj.getThirdArgument();
			arg.accept(this);
		}
	}
	public void visit(VariadicExpression obj) {
		for (Expression exp : obj.getArguments()) {
			if (exp instanceof Set) {
				Set arg = (Set) exp;
				arg.accept(this);
			}
		}
	}
	public void visit(Set obj) {
		Identifier id = (Identifier) obj.getFirstArgument();
		id.accept(this);
	}
}
