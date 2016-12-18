package pex.app.main;

import java.util.Iterator;

import pt.utl.ist.po.ui.Command;

import pex.app.App;
import pex.core.Program;
import pex.core.expression.Expression;


/**
 * Open menu for managing programs.
 */
public class AppendProgram extends Command<App> {
    /**
     * @param receiver
     */
    public AppendProgram(App receiver) {
        super("Juntar dois programas", receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		String programId1 = entity().readString(title(), Message.requestProgramId());
		String programId2 = entity().readString(title(), Message.requestProgramId());

		Program p1 = entity().getInterpreter().getProgram(programId1);
		if (p1 == null) {
			entity().println(Message.noSuchProgram(programId1));
			return;
		}
		Program p2 = entity().getInterpreter().getProgram(programId2);
		if (p2 == null) {
			entity().println(Message.noSuchProgram(programId2));
			return;
		}

		int idx = p1.getNumExpressions();
		Iterator<Expression> iter = p2.getChildIterator();
		while (iter.hasNext()) {
			Expression exp = iter.next();
			p1.add(idx++, exp);
		}
    }

}
