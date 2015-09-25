package lab04;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab04b
{
	public static void main ( String[] args )
	{
		FirstAndLast demo = new FirstAndLast("Hello");
		demo.findFirstLastLetters();
		out.println(demo);

		FirstAndLast d = new FirstAndLast("World");
		d.findFirstLastLetters();
		out.println(d);
		
		FirstAndLast de = new FirstAndLast("JukeBox");
		de.findFirstLastLetters();
		out.println(de);
		
		FirstAndLast dem = new FirstAndLast("TCEA");
		dem.findFirstLastLetters();
		out.println(dem);
		
		FirstAndLast demoi = new FirstAndLast("UIL");
		demoi.findFirstLastLetters();
		out.println(demoi);
		//add more test cases
		
		
		
		
	}
}