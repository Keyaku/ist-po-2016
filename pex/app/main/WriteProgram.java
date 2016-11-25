package pex.app.main;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import pex.app.App;
import pex.core.Program;

import pt.utl.ist.po.ui.Command;
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

		// Check if program exists
		Program p = entity().getInterpreter().getProgram(programId);
		if (p == null) {
			entity().println(Message.noSuchProgram(programId));
			return;
		}

		// Attempt to write to file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.write(p.getAsText());
			writer.close();
		} catch (IOException e) {
			throw new InvalidOperation("Não foi possível criar o ficheiro.");
		}
    }
}
