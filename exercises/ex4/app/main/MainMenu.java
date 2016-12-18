package pex.app.main;

import pex.app.App;

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
    public MainMenu(App receiver) {
        super(Label.TITLE,
            new Command<?>[] {              //
				new New(receiver),          // Command for creating a new interpreter.
				new Open(receiver),         // Open existing interpreter.
				new Save(receiver),         // Save to file under current name.
				new NewProgram(receiver),   // Create new program.
				new ReadProgram(receiver),  // Read existing program.
				new WriteProgram(receiver), // Write (save) program to file.
				new EditProgram(receiver),  // Open menu for managing programs.
				new AppendProgram(receiver),
            }
		);
    }
}
