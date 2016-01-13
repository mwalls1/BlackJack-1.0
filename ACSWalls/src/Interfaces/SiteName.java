package Interfaces;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

class SiteName implements Comparable<SiteName>
{
	//add instance variables
	private String fname;
	private String name;
	private String ext;
	
	//add a constructor
	public SiteName(String a)
	{
		fname = a;
		name = a.substring(0,a.indexOf('.'));
		ext = a.substring(a.indexOf('.')+1);
	}

	//add a compareTo
	public int compareTo(SiteName other)
	{
		if(this.ext.compareTo(other.ext)==0)
			return this.name.compareTo(other.name);
		else
			return this.ext.compareTo(other.ext);
	}

	//add a toString
	public String toString()
	{
		return fname;
	}
}