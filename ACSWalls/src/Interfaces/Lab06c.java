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

public class Lab06c
{
	public static void main ( String[] args ) throws IOException
	{
	   //add test cases
		ArrayList<Person> myList=new ArrayList<Person>();
		Scanner scan=new Scanner(new File("data/lab06c.dat"));
		scan.nextInt();
		while(scan.hasNext())
			myList.add(new Person(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextLine()));
		Collections.sort(myList);
		for(Person words: myList)
		{
			System.out.println(words);
		}

	}
}