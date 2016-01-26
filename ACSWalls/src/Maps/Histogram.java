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
		
	}

	public Histogram(String sent)
	{
		String[] list = sent.split(" "); 
		String key = list[0];
		String value = list[1];
		histogram.put(key, Integer.parseInt(value));
	}
	
	public void setSentence(String sent)
	{
		histogram = new TreeMap<String, Integer>();
		String[] list = sent.split(" "); 
		for(int i = 0; i < list.length; i ++)
		{
			if(histogram.get(list[i])==null)
			{
				histogram.put(list[i], 0);
			}
			histogram.put(list[i],histogram.get(list[i]+1));
		}
	}

	public String toString()
	{
		String allStars = "";
		String output = "";
		
		for(String s: histogram.keySet()){
			for(int i=0; i<histogram.get(s);i++){
				output+="*";
			}
			System.out.println("\n");
			
		}
		return output+"\n\n";
	}
}