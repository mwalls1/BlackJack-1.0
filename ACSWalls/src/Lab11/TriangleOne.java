package Lab11;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class TriangleOne
{
   //this lab is setup with a single static method
   //there are no instance variables or additional methods / constructors
	public static String createTriangle( String let, int size)
	{
		String output = "";
		for(int i = 0;i<=size;i++)
		{
			for(int j = 0;j<i;j++)
			{
			output+=let;	
			}
			output+="\n";
		}
		return output;
	}
}