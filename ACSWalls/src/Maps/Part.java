package Maps;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Part implements Comparable<Part>
{
	private String make, mode, rest;
	private int year;

	public Part(String line) 
	{
		String[] list = line.split(" ");
		rest = "";
		make = list[list.length-3];
		mode = list[list.length-2];
		year = Integer.parseInt(list[list.length-1]);
		for(int i = 0; i < list.length-3; i ++)
		{
			rest +=" "+list[i];
			
		}



	}

	//have to have compareTo if implements Comparable
	public int compareTo( Part other)
	{
		if (this.make.compareTo(other.make)>0)
			return 1;
		if (this.make.compareTo(other.make)<0)
			return -1;
		else if(this.mode.compareTo(other.mode)>0)
			return 1;
		else if(this.mode.compareTo(other.mode)<0)
			return -1;
		else if(this.year>other.year)
			return 1;
		else if(this.year<other.year)
			return -1;
		return this.rest.compareTo(other.rest);
	}

	public String toString()
	{
		return make + " "+mode+" "+year+" "+rest;
	}
}