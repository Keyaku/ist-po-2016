package pex.app.evaluator;

import pex.app.BadExpressionException;
import pex.app.BadPositionException;

import pex.parser.*;

import pex.core.Program;
import pex.core.expression.Expression;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Replace expression in program.
 */
public class ReplaceExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public ReplaceExpression(Program receiver) {
        super(Label.REPLACE_EXPRESSION, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
		Form f = new Form(title());
		InputInteger inputPos = new InputInteger(f, Message.requestPosition());
		InputString inputExp = new InputString(f, Message.requestExpression());
		f.parse();

		NewParser parser = new NewParser();
		Expression exp = null;
		int idx = inputPos.value();

		// Check position value
		if (!(0 <= idx && idx < entity().getNumExpressions())) {
			throw new BadPositionException(idx);
		}

		// Attempt to parse expression
		try {
			exp = parser.parseString(inputExp.value(), entity());
		} catch (BadSourceException|BadNumberException|InvalidExpressionException|MissingClosingParenthesisException|UnknownOperationException|EndOfInputException e) {
			throw new BadExpressionException(inputExp.value());
		}

		// Finally, replace expression
		entity().replace(idx, exp);
    }
}
