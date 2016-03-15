package Stacks;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Stack;
import static java.lang.System.*;

public class StackTester
{
	private Stack<String> stack;

	public StackTester()
	{
		stack = new Stack<String>();
	}
	
	public void setStack(String line)
	{
		String[] s = line.split(" ");
		for(int i = 0; i < s.length; i ++)
		{
			stack.add(s[i]);
		}
		System.out.println(stack);
	}

	public void popEmAll()
	{	
		System.out.println("Popping Stack\n"+stack);
		while(!stack.isEmpty())
			stack.pop();
		System.out.println(stack);
	}

	//add a toString
}