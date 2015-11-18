package Lab13;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

import java.util.Scanner;

public class TheLine {
	private String line;

	public TheLine() {

	}

	public TheLine(String s) {
		line = s;

	}

	public int getLargest() {
		int largest = Integer.MIN_VALUE;
		int current = 0;

		Scanner scan = new Scanner(line);
		scan.useDelimiter(" ");

		while (scan.hasNextInt())
		{
			current = scan.nextInt();
			if (current > largest)
				largest = current;
		}

		return largest;
	}

	public String toString() {
		return "Largest: " + getLargest();
	}
}