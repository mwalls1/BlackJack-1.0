package translate;

import java.util.Scanner;

import com.temboo.core.TembooException;

public class translateRun
{
	public static void main(String[] args) throws TembooException
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Language to translate to: ")
		System.out.print("Enter a string to translate: ");
		translateChange trans = new translateChange(scan.nextLine());
		trans.translate();
		System.out.println(trans);	
	}
	
}
