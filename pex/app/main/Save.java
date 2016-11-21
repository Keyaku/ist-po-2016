package pex.app.main;

import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import pex.app.App;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<App> {
    /**
     * @param receiver
     */
    public Save(App receiver) {
        super(Label.SAVE, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        // Check associated filename
		String filename;

		// if it doesn't exist, use Message.newSaveAs()
		filename = entity().getInterpreter().getFilename();
		if (filename == null) {
			Form f = new Form(title());
			InputString is = new InputString(f, Message.newSaveAs());
			f.parse();
			filename = is.value();
			entity().getInterpreter().setFilename(filename);
		}

		// don't do anything if there were no changes
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(entity().getInterpreter());
			out.close();
		} catch (IOException e) {
			// do nothing
		}
    }
}
