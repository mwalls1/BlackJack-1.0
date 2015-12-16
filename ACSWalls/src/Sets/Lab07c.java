package Sets;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab07c
{
	public static void main(String args[]) throws IOException
	{
		boolean a = true;
		String one = "";
		String two = "";
		MathSet mySet;
		try {
			Scanner scan = new Scanner(new File("data/lab07c.dat"));
			while(scan.hasNext())
			{
				if(a)
				{
					one+=scan.nextLine();
				}
				else
					two+=scan.nextLine();
				a=!a;
				mySet = new MathSet(one,two);
				System.out.println(mySet);
				
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
