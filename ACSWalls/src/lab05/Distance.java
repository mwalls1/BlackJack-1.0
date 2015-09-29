//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int x1,y1,x2,y2;

	public Distance()
	{


	}

	public Distance(int xOne, int yOne, int xTwo, int yTwo)
	{
		x1 = xOne;
		x2 = xTwo;
		y1 = yOne;
		y2 = yTwo;

	}

	public void setCoordinates(int xOne, int yOne, int xTwo, int yTwo)
	{

		x1 = xOne;
		x2 = xTwo;
		y1 = yOne;
		y2 = yTwo;
	}

	public String determineClosest( )
	{
		double distanceA = 0.0, distanceB = 0.0;
		String result=0;
		distanceA = Math.sqrt(Math.pow(x2-0,2)+Math.pow(y2-0,2));
		distanceB = Math.sqrt(Math.pow(x1-0,2)+Math.pow(y1-0,2));
		



		return result;
	}
	
	public String toString()
	{
		return "";
	}
}