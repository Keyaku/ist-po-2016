package pex.app.main;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import pex.app.App;
import pex.core.Program;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Write (save) program to file.
 */
public class WriteProgram extends Command<App> {
    /**
     * @param receiver
     */
    public WriteProgram(App receiver) {
        super(Label.WRITE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        Form f = new Form(title());
		InputString iiProgramId = new InputString(f, Message.requestProgramId());
		InputString isProgramName = new InputString(f, Message.programFileName());
		f.parse();

		String programId = iiProgramId.value();
		String filename = isProgramName.value();
		Program p = entity().getInterpreter().getProgram(programId);

		if (p == null) {
			throw new InvalidOperation(Message.noSuchProgram(programId));
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.write(p.getAsText());
			writer.close();
		} catch (IOException e) {
			// Do nothing
		}
    }
}
