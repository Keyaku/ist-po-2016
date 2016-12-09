package pex.core.visitors;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

import pex.core.*;
import pex.core.expression.*;

public class IdentifierVisitor extends Visitor {
	public void visitProgram(Program program) {
		Iterator<Expression> iter = program.getChildIterator();

		while (iter.hasNext()) {
            Expression exp = iter.next();

            if (exp instanceof Identifier) {
				Identifier id = (Identifier) exp;
				program.setIdentifierValue(id, new IntegerLiteral(0));
            }
        }
	}
}
