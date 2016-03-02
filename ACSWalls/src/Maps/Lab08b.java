package Maps;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab08b
{
	public static void main( String args[] ) throws IOException
	{
		Scanner scan = new Scanner(new File("data/lab08b.dat"));
		Histogram test = new Histogram();
		while(scan.hasNextLine())
			for(int i = 0; i < 1; i ++)
				test = new Histogram(scan.nextLine());
			out.println(test);
		
		
		
		
		
		
		
	}
}