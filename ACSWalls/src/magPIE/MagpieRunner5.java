package magPIE;
import java.util.Scanner;

import com.temboo.core.TembooException;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
 
public class MagpieRunner5
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 * @throws TembooException 
	 */
	public static void main(String[] args) throws TembooException
	{
		Magpie5 maggie = new Magpie5();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}