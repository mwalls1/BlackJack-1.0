package lab04;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Name
{
	private String name;
	private String[] names;
	public Name()
	{


	}

	public Name(String s)
	{
		name = s;
		names = name.split(" ");
	}

   public void setName(String s)
   {
	   name = s;
	   names = name.split(" ");
   }

	public String getFirst()
	{
		return names[0];
	}

	public String getLast()
	{
		return names[1];
	}

 	public String toString()
 	{
 		return name+"\n\n";
	}
}