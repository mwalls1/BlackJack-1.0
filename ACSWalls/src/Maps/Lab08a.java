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

public class Lab08a
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("data/lab08a.dat"));

		SpanishToEnglish test = new SpanishToEnglish();

		//read in pairs from the file and load the map
		int num = file.nextInt();
		file.nextLine();
		for(int i = 0; i<num; i ++)
		{
			test.putEntry(file.nextLine());
		}

		out.println("\n====\tMAP CONTENTS\t====\n\n");

		//print the map

		out.println(test+"\n\n");
		while(file.hasNext())
		{
			String sent = file.nextLine();
			System.out.println(test.translate(sent));
		}
	}
}