package Lab13;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.lang.Math;

public class Lab13d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("data/lab13d.dat"));
		int num = file.nextInt();
		for(int i = 0; i < num; i ++)
		{
			String food = file.nextLine();
			//file.nextLine();
			DogFood foods = new DogFood(food);
			System.out.print(foods);
		}









	}
}