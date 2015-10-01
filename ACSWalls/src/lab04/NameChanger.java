package lab04;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class NameChanger
{
	String first ="";
	String last = "";
	public NameChanger(String f, String l)
	{
		first = f;
		last = l;

	}
	public void scramble()
	{
		first = first.replace(first.charAt(first.length()-1),'q');
		last = last.replace(last.charAt(last.length()-1), 'z');
	}
	public void setNames(String f, String l)
	{
		first = f;
		last = l;
	}
	public void reverse()
	{
		String temp = "";
		String tempp = "";
		for(int i = first.length()-1;i>=0;i--)
		{
			temp+=first.substring(i,i+1);
		}
		first = temp;
		tempp+=last.substring(last.length()/2);
		tempp+=last.substring(0, last.length()/2);
		last = tempp;
		
	}
	public String toString()
	{
		String out = "";
		out+= "First name: "+first+"\n\nLast name: "+last;
		return out;
	}
	
}
