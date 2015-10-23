package translate;

import java.util.Scanner;

import javax.swing.JPanel;

import com.temboo.core.TembooException;

public class translateRun extends JPanel
{
	public static void main(String[] args) throws TembooException 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Language to translate to: ");
		String language = scan.nextLine();
		System.out.print("Enter a string to translate: ");
		translateChange trans = new translateChange(scan.nextLine(), language);
		trans.translate();
		System.out.println(trans);	
	}
	
	
}
