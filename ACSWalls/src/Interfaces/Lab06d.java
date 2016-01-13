package Interfaces;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class Lab06d
{
	public static void main ( String[] args ) throws IOException
	{
		ArrayList<SiteName> myList=new ArrayList<SiteName>();
		Scanner scan=new Scanner(new File("data/lab06d.dat"));
		scan.nextInt();
		scan.nextLine();
		while(scan.hasNext())
			myList.add(new SiteName(scan.nextLine()));
		
		Collections.sort(myList);
		for(SiteName words: myList)
		{
			System.out.println(words);
		}
		
	}
}
