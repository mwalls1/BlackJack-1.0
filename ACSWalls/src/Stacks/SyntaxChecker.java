package Stacks;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Stack;
import static java.lang.System.*;

public class SyntaxChecker {
	private String exp;
	private Stack<Character> symbols;

	public SyntaxChecker() {
		symbols = new Stack<Character>();
	}

	public SyntaxChecker(String s) {
		symbols = new Stack<Character>();
		exp = s;
	}

	public void setExpression(String s) {
		exp = s;
	}

	public boolean checkExpression() {
		char[] chars = exp.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '<' || chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
				symbols.push(chars[i]);
			} else if (chars[i] == '>' || chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
				if (!symbols.isEmpty()) {
					char a = symbols.pop();
					if (a == '('&&chars[i]==')'||a == '<'&&chars[i]=='>'||a == '{'&&chars[i]=='}'||a == '['&&chars[i]==']') {
						break;
					} else
						return false;
				}
			}
		}
			return true;

	}

	// write a toString
	public String toString() {
		String fin = "";
		if (checkExpression()) {
			fin += exp + " is ok";
		} else
			fin += exp + " is not ok";
		return fin;
	}
}