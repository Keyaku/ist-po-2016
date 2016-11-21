package pex.app.evaluator;

import pex.core.Interpreter;


import pex.core.Program;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Menu for program manipulation.
 */
public class EvaluatorMenu extends Menu {
    /**
     * @param receiver
     */
    public EvaluatorMenu(Program receiver) {
        super(Label.TITLE,
            new Command<?>[] {                              //
                new ShowProgram(receiver),                  // Show program (present code).
                new RunProgram(receiver),                   // Run program.
                new AddExpression(receiver),                // Add expression.
                new ReplaceExpression(receiver),            // Replace expression in program.
                new ShowAllIdentifiers(receiver),           // Show all program identifiers.
                new ShowUninitializedIdentifiers(receiver), // Show uninitialized identifiers.
			}
		);
    }

}
