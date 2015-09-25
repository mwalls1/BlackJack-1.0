package lab05;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class Lab05a
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		out.print("Enter the original bill amount :: ");
		double amt = keyboard.nextDouble();
		System.out.println("Bill after discount :: "+Discount.getDiscountedBill(amt));
		

	}
}