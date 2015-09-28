package lab05;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
public class Lab05c
{
	public static void main ( String[] args )
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word :: ");
		String word = scan.nextLine();
		StringOddOrEven www = new StringOddOrEven(word);
		System.out.println(www+" is "+www.isEven());
		
		System.out.print("Enter a word :: ");
		word = scan.nextLine();
		www.setString(word);
		System.out.println(www+" is "+www.isEven());
		System.out.print("Enter a word :: ");
		word = scan.nextLine();
		www.setString(word);
		System.out.println(www+" is "+www.isEven());
		System.out.print("Enter a word :: ");
		word = scan.nextLine();
		www.setString(word);
		System.out.println(www+" is "+www.isEven());
		System.out.print("Enter a word :: ");
		word = scan.nextLine();
		www.setString(word);
		System.out.println(www+" is "+www.isEven());
		System.out.print("Enter a word :: ");
		word = scan.nextLine();
		www.setString(word);
		System.out.println(www+" is "+www.isEven());
		System.out.print("Enter a word :: ");
		word = scan.nextLine();
		www.setString(word);
		System.out.println(www+" is "+www.isEven());
		System.out.print("Enter a word :: ");
		word = scan.nextLine();
		www.setString(word);
		System.out.println(www+" is "+www.isEven());
	}
}