package pex.app.evaluator;

import java.util.ArrayList;

import pex.core.Program;
import pex.core.expression.Expression;

/**
 * Replace expression in program.
 */
public class ClearProgram extends ProgramCommand {
    /**
     * @param receiver
     */
    public ClearProgram(Program receiver) {
        super("Limpar programa", receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		// Finally, replace expression
		entity().set(new ArrayList<Expression>());
    }
}
