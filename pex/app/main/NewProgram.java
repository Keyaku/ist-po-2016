package pex.app.main;

import pex.core.Interpreter;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Create new program.
 */
public class NewProgram extends Command<Interpreter> {

    /**
     * @param receiver
     */
    public NewProgram(Interpreter receiver) {
        super(Label.NEW_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        //FIXME implement
    }
}
