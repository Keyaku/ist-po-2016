package pex.app.evaluator;

import pex.core.visitors.*;
import pex.core.expression.*;
import pex.core.Program;

import pt.utl.ist.po.ui.Display;

/**
 * Show all program identifiers.
 */
public class ShowIdentifierValues extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowIdentifierValues(Program receiver) {
        super("Mostrar todos os identificadores e respectivos valores", receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		IdentifierVisitor idVisitor = new IdentifierVisitor();

		entity().execute();
		entity().accept(idVisitor);

		Display d = new Display(title());
		for (Identifier id : idVisitor.getAllIdentifiers()) {
			d.addNewLine(id.evaluate().getAsText() + " : " + id.getAsText());
		}
		d.display();
    }
}
