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

public class Histogram
{
	private Map<String,Integer> histogram;

	public Histogram()
	{
		histogram = new TreeMap<String, Integer>();
	}

	public Histogram(String sent)
	{
		String[] list = sent.split(" "); 
		String key = list[0];
		String value = list[1];
		histogram.put(key, Integer.parseInt(value));
	}
	
	public void setSentence()
	{
	}

	public String toString()
	{
		String output="";
		String allStars="";
		return output+"\n\n";
	}
}