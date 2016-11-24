package pex.app;

import java.io.Serializable;

// import core entities;
import pex.AppIO;
import pex.parser.NewParser;
import pex.core.Program;
import pex.core.Interpreter;

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
public class App implements AppIO, Serializable {
	Interpreter _interpreter;

    public App() {
		_interpreter = new Interpreter(this);
    }

	// AppIO methods
    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {
		Display d = new Display();
		d.addNewLine(str);
		d.display();
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString(String title, String message) {
		Form f = new Form(title);
        InputString is = new InputString(f, message);
		f.parse();
		return is.value();
    }

    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger(String title, String message) {
		Form f = new Form(title);
        InputInteger ii = new InputInteger(f, message);
		f.parse();
		return ii.value();
    }

	// Helper methods
	public Interpreter getInterpreter() {
		return _interpreter;
	}

	public void setInterpreter(Interpreter value) {
		_interpreter = value;
	}

    /**
     * @param args
     */
    public static void main(String[] args) {
		App app = new App();

        String datafile = System.getProperty("import"); //$NON-NLS-1$
        if (datafile != null) {
            try {
				NewParser parser = new NewParser();
				Program pImport = parser.parseFile(datafile, "import");
				app.getInterpreter().addProgram(pImport);
            } catch (ParserException e) {
                // no behavior described: just present the problem
                e.printStackTrace();
            }
        }

        MainMenu menu = new MainMenu(app);
        menu.open();
    }
}
