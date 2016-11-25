package pex.app.main;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.ObjectInputStream;
import java.io.FileInputStream;

import pex.app.App;
import pex.core.Interpreter;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Open existing interpreter.
 */
public class Open extends Command<App> {
    /**
     * @param receiver
     */
    public Open(App receiver) {
        super(Label.OPEN, receiver);
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
		String filename = entity().readString(title(), Message.openFile());

		// Opening file
		try {
	    	ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			entity().setInterpreter((Interpreter)in.readObject());
			in.close();
		} catch (FileNotFoundException e) {
			entity().println(Message.fileNotFound());
		} catch (IOException|ClassNotFoundException e) {
			entity().println(Message.fileNotFound(filename));
		}
    }
}
