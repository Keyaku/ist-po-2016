package pex.app.main;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import pex.app.App;
import pex.core.Program;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
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
		String programId = entity().readString(title(), Message.requestProgramId());
		String filename = entity().readString(title(), Message.programFileName());
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
