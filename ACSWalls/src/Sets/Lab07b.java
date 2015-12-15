package Sets;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab07b
{
	public static void main( String args[] ) throws IOException
	{
		//more test cases
		String nums = "";
		try {
			Scanner file = new Scanner(new File("data/lab07b.dat"));
			while (file.hasNext()) {
				 nums += file.next()+" ";
			}
			}catch(Exception e){
				System.out.print(e);
			}
		OddEvenSets odd = new OddEvenSets(nums);
		System.out.println(odd);
	}
}