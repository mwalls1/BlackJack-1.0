package Iterator;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.System.*;

public class Lab05a
{
	public static void main ( String[] args )
	{
		//add test cases	
		String words = "my mother has my car in my garage. shes my favorite";
		IteratorTest myIt = new IteratorTest(words, "my");
		myIt.remove();
		System.out.println(myIt);
	}
}