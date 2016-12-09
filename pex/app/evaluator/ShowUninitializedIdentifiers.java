package pex.app.evaluator;

import pex.core.visitors.*;
import pex.core.Program;

import pt.utl.ist.po.ui.Display;

/**
 * Show uninitialized identifiers.
 */
public class ShowUninitializedIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowUninitializedIdentifiers(Program receiver) {
        super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		IdentifierVisitor idVisitor = new IdentifierVisitor();
		entity().accept(idVisitor);

		Display d = new Display(title());

		// FIXME: Grab all IDs from Visitor
		// FIXME: Iterate through all IDs, and grab only those whose Literal == IntegerLiteral(0)
		// d.addNewLine(id.getAsText());

		d.display();
    }
}
