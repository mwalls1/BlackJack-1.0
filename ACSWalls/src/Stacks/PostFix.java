package Stacks;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Stack;
import java.util.Scanner;
import static java.lang.System.*;

public class PostFix
{
	private Stack<Double> stack;
	private String expression;

	public PostFix()
	{
	}

	public PostFix(String exp)
	{
		stack = new Stack<Double>();
		expression = exp;
	}

	public void setExpression(String exp)
	{
		expression = exp;
	}


	public double solve()
	{
		String[] chars = expression.split(" ");
		for(int i = 0; i < chars.length; i ++)
		{
			try
			{
				stack.push(Double.parseDouble(chars[i]));
			}
			catch(Exception e)
			{
				double b = stack.pop();
				double a = stack.pop();
				double c;
				if(chars[i].equals("+"))
					c = a+b;
				else if(chars[i].equals("-"))
					c = a-b;
				else if(chars[i].equals("*"))
					c=a*b;
				else
					c=a/b;
				stack.push(c);
			}
		}
		return stack.pop();
	}

	//add a toString
}