package lab04;
import java.util.*;
public class lab04f {

	public static void main(String[] args)
	{
		String yn = "";
		do
		{
		Scanner scan = new Scanner (System.in);
		System.out.print("Please enter a first name: ");
		String first = scan.nextLine();
		System.out.print("Please enter a last name: ");
		String last = scan.nextLine();
		System.out.print("What is your favorite sport?: ");
		String sport = scan.nextLine();
		NameChanger change = new NameChanger(first,last);
		change.scramble();
		change.reverse();
		System.out.println(change.toString()+"\n\nFavorite sport: "+sport);
		System.out.println("Continue? (y/n)");
		yn = scan.nextLine();
		}while(yn.equals("y"));
		

	}

}
