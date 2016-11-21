package pex.app.main;

import pex.app.App;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Create new program.
 */
public class NewProgram extends Command<App> {

    /**
     * @param receiver
     */
    public NewProgram(App receiver) {
        super(Label.NEW_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form(title());
        InputString is = new InputString(f, Message.RequestProgramId());
        f.parse();
        String nameprogram = is.value();
        entity().getInterpreter().addProgram(new Program(nameprogram)); 
    }
}
