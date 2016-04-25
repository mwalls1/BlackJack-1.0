package HashMaps;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import static java.lang.System.*;

public class Lab16a
{
  public static void main ( String[] args )
  {

	  
		
			//make a new table
	  try
	  {
		  HashTable table = new HashTable();
		  Scanner scan = null;
			scan = new Scanner(new File("res/lab16a.dat"));
			//load stuff into the table
			while(scan.hasNext())
			{
				table.add(new Number(scan.nextInt()));
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
