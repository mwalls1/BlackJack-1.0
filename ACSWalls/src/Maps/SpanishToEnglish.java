package Maps;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanishToEnglish {
	private Map<String, String> pairs;

	public SpanishToEnglish() {

		pairs = new TreeMap<String, String>();

	}

	public void putEntry(String entry) {
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);
		/*
		 * for(int i = 0; i < list.length-1; i ++) {
		 * pairs.put(list[i],list[i+1]); }
		 */
	}

	public String translate(String sent) {
		Scanner chop = new Scanner(sent);
		String output = "";
		while (chop.hasNext()) {
			output += pairs.get(chop.nextLine()) + " ";
		}
		return output;
	}

	public String toString() {
		return pairs.toString().replaceAll("\\,", "\n");
	}
}