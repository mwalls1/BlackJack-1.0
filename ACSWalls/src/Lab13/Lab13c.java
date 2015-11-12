package Lab13;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab13c
{
	public static void main( String args[] ) throws IOException
	{
		Scanner scan = new Scanner(new File("data/lab13c.dat"));
		int num = scan.nextInt();
		for(int i=0 ; i<num; i++)
		{
			String line = scan.nextLine();
			Social result = new Social(line);
			System.out.println(result);
		}








	}
}