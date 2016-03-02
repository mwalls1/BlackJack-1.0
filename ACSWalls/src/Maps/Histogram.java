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
	String[] t;
	public Histogram()
	{
		
	}

	public Histogram(String sent)
	{
		setSentence(sent);
	}
	
	public void setSentence(String sent)
	{
		histogram = new TreeMap<String, Integer>();
		t = sent.split(" "); 
		
		for(int i = 0; i < t.length; i ++)
		{
			System.out.println(histogram.get(t[i]));
			if(histogram.get(t[i])==null)
			{
				histogram.put(t[i], 0);
				histogram.put(t[i],histogram.get(t[i]+1));
			} 
			else
			{
				System.out.println("pls");
				histogram.put(t[i],histogram.get(t[i]+1));
			}
		}
		System.out.println(histogram.values());
	}

	public String toString()
	{
		String output = "";
		output+="char	1---5----01---5\n";
		for(String s: histogram.keySet()){
			output+=s+"\t";
			
			for(int i=0; i<histogram.get("a");i++){
				output+="*";
			}
			output+="\n";
			
		}
		return output+"\n\n";
	}
}