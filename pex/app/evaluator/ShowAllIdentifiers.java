package pex.app.evaluator;

import pex.core.visitors.*;
import pex.core.expression.Identifier;
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
		for (Identifier id : idVisitor.getAllIdentifiers()) {
			d.addNewLine(id.getAsText());
		}
		d.display();
    }
}
