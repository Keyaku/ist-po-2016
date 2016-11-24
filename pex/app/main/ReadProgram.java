package pex.app.main;

import java.io.IOException;

import pex.app.App;
import pex.parser.NewParser;
import pex.parser.ParserException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Read existing program.
 */
public class ReadProgram extends Command<App> {
    /**
     * @param receiver
     */
    public ReadProgram(App receiver) {
        super(Label.READ_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		Form f = new Form(title());
		InputString is = new InputString(f, Message.programFileName());
		f.parse();
		String filename = is.value();

		try {
			NewParser parser = new NewParser();
			entity().getInterpreter().addProgram(parser.parseFile(filename, filename));
		} catch (ParserException e) {
			// Do nothing
		}
    }
}
