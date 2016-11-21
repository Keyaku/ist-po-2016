package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.FileInputStream;

import pex.app.App;
import pex.core.Interpreter;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
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
		Form f = new Form(title());

		InputString filename = new InputString(f, Message.openFile());
		f.parse();

		try {
	    	ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename.value()));
			entity().setInterpreter((Interpreter)in.readObject());
			in.close();
		} catch (FileNotFoundException e) {
			throw new InvalidOperation(Message.fileNotFound());
		} catch (IOException e) {
			throw new InvalidOperation(Message.fileNotFound(filename.value()));
		} catch (ClassNotFoundException e) { // FIXME: this should not be here
			throw new InvalidOperation(Message.fileNotFound());
		}
    }
}
