package pex.core.instruction;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Sub extends BinaryExpression {
	public Sub(Expression arg1, Expression arg2) {
		super(arg1, arg2);
	}

	public String getAsText() {
		return "(sub " +
			getFirstArgument().getAsText()  + " " +
			getSecondArgument().getAsText() +
			")";
	}

	public Literal evaluate() {
		IntegerLiteral lit1 = (IntegerLiteral) getFirstArgument();
		IntegerLiteral lit2 = (IntegerLiteral) getSecondArgument();
		int result = lit1.intValue() - lit2.intValue();
		return new IntegerLiteral(result);
	}
}
