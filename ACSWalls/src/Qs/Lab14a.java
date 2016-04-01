package Qs;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab14a
{
	public static void main ( String[] args )
	{
		//add test cases	
		PalinList myList = new PalinList("one two three two one");
		System.out.println(myList);
		myList.setList("1 2 3 4 5 one two three four five");
		System.out.println(myList);
		myList.setList("racecar is racecar");
		System.out.println(myList);
	}
}