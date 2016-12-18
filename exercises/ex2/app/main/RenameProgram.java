package pex.app.main;

import java.io.IOException;

import pex.app.App;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Read existing program.
 */
public class RenameProgram extends Command<App> {
    /**
     * @param receiver
     */
    public RenameProgram(App receiver) {
        super("Mudar nome de um programa", receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		String programId = entity().readString(title(), Message.requestProgramId());
		String newName = entity().readString(title(), "Novo nome: ");

		Program p = entity().getInterpreter().getProgram(programId);
		if (p == null) {
			entity().println(Message.noSuchProgram(programId));
			return;
		}

		entity().getInterpreter().removeProgram(p);
		p.setName(newName);
		entity().getInterpreter().addProgram(p);
    }
}
