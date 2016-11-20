package pex.app;

// import core entities;
import pex.AppIO;
import pex.parser.ParserException;
import pex.app.main.MainMenu;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App implements AppIO {
    // Add fileds here if needed

    public App() {
		// FIXME: add core here if needed
    }

    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {
        // FIXME: add code here
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString() {
        // FIXME: add code here
		return "";
    }

    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger() {
        // FIXME: add code here
		return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //FIXME create main core object

        String datafile = System.getProperty("import"); //$NON-NLS-1$
        if (datafile != null) {
            try {
                // FIXME: read import file into core object (use Parser instance)
            } catch (ParserException e) {
                // no behavior described: just present the problem
                e.printStackTrace();
            }
        }

		// FIXME: properly set this up.
		AppIO app = new App();

        MainMenu menu = new MainMenu(app);
        menu.open();
    }
}
