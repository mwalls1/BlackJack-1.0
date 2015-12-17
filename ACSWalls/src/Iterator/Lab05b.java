package Iterator;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import static java.lang.System.*;

public class Lab05b
{
	public static void main ( String[] args )
	{
		//add test cases	
		String words = "my mother has my car in my garage. shes my favorite";
		ListIteratorTest myIt = new ListIteratorTest(words, "my","be");
		myIt.replace();
		System.out.println(myIt);
	}
}