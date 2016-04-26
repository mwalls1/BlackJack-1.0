package HashMaps;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

public class Word
{
	private String theValue;
	
	//write a constructor method
	public Word(String a)
	{
		theValue = a;
	}
	
	
	//write the getValue method
	public String getValue()
	{
		return theValue;
	}
	
	
	//write the equals method
	public boolean equals(Object obj)
	{
		return theValue.equals(((Word)obj).theValue);
	}
	
	
	//write the hashCode method
	public int hashCode()
	{
		int i= 0;
		String s = theValue;
		s=s.replaceAll("[^aeiou]", "");
		System.out.println(s);
		i = (s.length()*theValue.length())%10;
		
		return i;
	}
	
	
	//write the toString method
	public String toString()
	{
		return theValue;
	}
	
}