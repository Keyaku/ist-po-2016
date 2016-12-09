package pex.app.evaluator;

import pex.core.visitors.*;
import pex.core.Program;

import pt.utl.ist.po.ui.Display;

/**
 * Show all program identifiers.
 */
public class ShowAllIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowAllIdentifiers(Program receiver) {
        super(Label.SHOW_ALL_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		IdentifierVisitor idVisitor = new IdentifierVisitor();
		entity().accept(idVisitor);

		Display d = new Display(title());

		// FIXME: Grab all IDs from Visitor
		// FIXME: Iterate through all IDs
		// d.addNewLine(id.getAsText());

		d.display();
    }
}
