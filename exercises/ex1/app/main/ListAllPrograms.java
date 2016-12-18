package pex.app.main;

import java.util.Iterator;

import pex.app.App;
import pex.core.Program;

import pt.utl.ist.po.ui.Command;


/**
 * Open menu for managing programs.
 */
public class ListAllPrograms extends Command<App> {

    /**
     * @param receiver
     */
    public ListAllPrograms(App receiver) {
        super("Mostrar todos os programas", receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		Iterator<Program> iter = entity().getInterpreter().getChildIterator();

		Display d = new Display(title());
		while (iter.hasNext()) {
			Program p = iter.next();
			d.add(p.getName());
			d.addNewLine(p.getAsText());
		}
		d.display();
    }

}
