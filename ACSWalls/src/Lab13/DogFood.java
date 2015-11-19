package Lab13;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import java.lang.Math;

public class DogFood {
	private double amount;
	private double bag = 60.0;

	public DogFood() {

	}

	public DogFood(String line) {
		Scanner chopper = new Scanner(line);
		double cups = 0;
		//chopper.useDelimiter(" ");
		int num;
		while (chopper.hasNextInt()) {
			num = chopper.nextInt();
			if (num >= 2 && num <= 4)
				cups += .5;
			else if (num >= 5 && num <= 7)
				cups += 1.0;
			else if (num >= 8 && num <= 9)
				cups += 1.5;
			else if (num >= 10 && num <= 19)
				cups += 2.0;
			else if (num >= 20 && num <= 39)
				cups += 3.5;
			else if (num >= 40 && num <= 59)
				cups += 4.5;
			else if (num >= 60 && num <= 79)
				cups += 6.0;
			else
				cups += 7.5;
		}
		cups*=7;
		amount = Math.floor(cups / bag);

	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		return "Bags needed: " + amount+ " - 10 POUND BAGS" +"\n";
	}
}