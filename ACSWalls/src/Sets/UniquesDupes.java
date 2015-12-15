package Sets;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes {
	public static Set<String> getUniques(String input) {
		Set<String> uniques = new TreeSet<String>();

		for (int i = 0; i < input.length(); i++) {
			uniques.add(input.substring(i, i + 1));
		}

		return uniques;
	}

	public static Set<String> getDupes(String input)
	{
		Set<String> dupes = new TreeSet<String>();
		Set<String> set1 = new TreeSet<String>();
		String[]words = input.split(" ");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
		for(String a: list)
		{
			if(!set1.add(a))
			{
				dupes.add(a);
			}
		}
		
		
		return dupes;
	}
}