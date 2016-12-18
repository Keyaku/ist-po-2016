package pex.app.evaluator;

import pex.app.BadExpressionException;
import pex.app.BadPositionException;

import pex.parser.*;

import pex.core.Program;
import pex.core.expression.Expression;

import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Replace expression in program.
 */
public class ShowExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public ShowExpression(Program receiver) {
        super("Mostrar expressão", receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadPositionException {
		Form f = new Form(title());
		InputInteger inputPos = new InputInteger(f, Message.requestPosition());
		f.parse();

		int idx = inputPos.value();

		// Check position value
		if (!(0 <= idx && idx < entity().getNumExpressions())) {
			throw new BadPositionException(idx);
		}

		// Finally, replace expression
		Display d = new Display(title());
		d.addNewLine(entity().getExpression(idx).getAsText());
		d.display()
    }
}
