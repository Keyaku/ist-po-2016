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
    public final void execute() throws InvalidOperation {
		Form f = new Form(title());
		InputString is = new InputString(f, Message.requestProgramId());
		f.parse();
		String programId = is.value();

		Program p = entity().getInterpreter().getProgram(programId);
		if (p == null) {
			throw new InvalidOperation(Message.noSuchProgram(programId));
		}

		Menu editMenu = new EvaluatorMenu(entity().getInterpreter().getProgram(programId));
		editMenu.open();
    }

}
