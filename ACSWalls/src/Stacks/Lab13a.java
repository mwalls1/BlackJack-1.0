package Stacks;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab13a
{
	public static void main ( String[] args )
	{
		//add test cases	
		String a = "my life is so great";
		String b = "nuts pistachios walnuts";
		StackTester stack = new StackTester();
		stack.setStack(a);
		stack.popEmAll();
		stack.setStack(b);
		stack.popEmAll();
		
	}
}
