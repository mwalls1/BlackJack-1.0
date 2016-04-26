package HashMaps;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;
import java.io.File;

public class Lab16b
{
  public static void main ( String[] args ) throws Exception
  {
	  try
	  {
		  HashTable table = new HashTable();
		  Scanner scan = null;
			scan = new Scanner(new File("data/lab16b.dat"));
			//load stuff into the table
			while(scan.hasNext())
			{
				table.add(new Word(scan.nextLine().trim()));
			}
			System.out.println(table);
			scan.close();
	  	}
			
			catch(Exception e)
			{
				System.out.println("Houston, we have a problem!");
			}//read from the file
			
			//print out the table
			
		}
  }
