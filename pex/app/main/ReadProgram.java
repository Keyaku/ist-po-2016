package pex.app.main;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;

import pex.app.App;
import pex.core.Program;
// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.StringLiteral;

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
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			Program p = new Program(filename);

			String line;
			for (int idx = 0; (line = reader.readLine()) != null; idx++) {
				p.add(idx, new StringLiteral(line));
			}

			reader.close();
			entity().getInterpreter().addProgram(p);
		} catch (IOException e) {
			// Do nothing
		}
    }
}
