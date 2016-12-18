package pex.app.main;

import java.util.Iterator;

import pex.app.App;
import pex.core.Program;

import pt.utl.ist.po.ui.Command;


/**
 * Open menu for managing programs.
 */
public class ShowLineCount extends Command<App> {

    /**
     * @param receiver
     */
    public ShowLineCount(App receiver) {
        super("Mostrar número de linhas de um programa", receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		String programId = entity().readString(title(), Message.requestProgramId());

		Program p = entity().getInterpreter().getProgram(programId);
		if (p == null) {
			entity().println(Message.noSuchProgram(programId));
			return;
		}

		entity().println(new String(p.getNumExpressions()));
    }

}
