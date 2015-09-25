package lab04;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StringRipper
{
	private String word;
	
	public StringRipper()
	{

	}

	public StringRipper(String s)
	{
		word = s;
	}
	
   public void setString(String s)
   {
	   word = s;
   }	

	public String ripString(int x, int y)
	{	
		 String output = word.substring(x,y);
		return output;
		
	}

 	public String toString()
 	{
 		return word+"\n\n";
	}
}