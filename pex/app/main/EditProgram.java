package pex.app.main;

import pex.app.App;
import pex.core.Program;

import pex.app.evaluator.EvaluatorMenu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;


/**
 * Open menu for managing programs.
 */
public class EditProgram extends Command<App> {

    /**
     * @param receiver
     */
    public EditProgram(App receiver) {
        super(Label.MANAGE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		String programId = entity().readString(title(), Message.requestProgramId());

		Program p = entity().getInterpreter().getProgram(programId);
		if (p == null) {
			Display d = new Display();
			d.addNewLine(Message.noSuchProgram(programId));
			d.display();
			return;
		}

		Menu editMenu = new EvaluatorMenu(p);
		editMenu.open();
    }

}
