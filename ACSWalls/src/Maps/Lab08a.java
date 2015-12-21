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
		String words = "";
		Scanner file = new Scanner(new File("data/lab08a.dat"));

		SpanishToEnglish test = new SpanishToEnglish();

		//read in pairs from the file and load the map
		int num=file.nextInt();
		for(int i=0; i<num; i++)
		{
			test.putEntry(file.next());
		}

		out.println("\n====\tMAP CONTENTS\t====\n\n");

		//print the map

		out.println(test+"\n\n");
	}
}