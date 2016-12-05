package pex.core;

import pex.core.expression.*;
import pex.core.instruction.*;

public class Test {
	public static void main(String[] args) {
		Literal lit1 = new IntegerLiteral(2);
		Literal lit2 = new IntegerLiteral(3);

		Add add = new Add(lit1, lit2);

		System.out.println(add.getAsText());
		System.out.println(add.evaluate().getAsText());
	}
}
