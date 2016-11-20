package pex.app.main;

import pex.core.Interpreter;
import pex.core.Program;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Menu builder.
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
*/
public class MainMenu extends Menu {
    /**
     * @param receiver The instanced Interpreter for this session
     */
    public MainMenu(Interpreter interpreter, Program program) {
        super(Label.TITLE,
            new Command<?>[] { //
				new New(interpreter),         // Command for creating a new interpreter.
				new Open(interpreter),        // Open existing interpreter.
				new Save(interpreter),        // Save to file under current name.
				new NewProgram(program),      // Create new program.
				new ReadProgram(program),     // Read existing program.
				new WriteProgram(program),    // Write (save) program to file.
				new EditProgram(interpreter), // Open menu for managing programs.
            }
		);
    }
}
