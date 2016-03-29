package Stacks;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class Lab13c
{
	public static void main ( String[] args )
	{
		//add test cases
		PostFix fix = new PostFix("2 7 + 1 2 + +");
		System.out.println(fix.solve());
		fix.setExpression("1 2 3 4 + + +");
		System.out.println(fix.solve());
		fix.setExpression("9 3 * 8 / 4 +");
		System.out.println(fix.solve());
	}
}