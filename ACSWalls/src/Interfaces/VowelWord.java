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

public class Lab06a
{
	public static void main( String args[] ) throws IOException
	{
		//add test cases
		ArrayList<Word> myList=new ArrayList<Word>();
		Scanner scan=new Scanner(new File("data/lab06a.dat"));
		while(scan.hasNext())
			myList.add(new Word(scan.next()));
		Collections.sort(myList);
		for(Word words: myList)
		{
			System.out.println(words);
		}
	}
}