package Qs;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab14c
{
	public static void main ( String[] args )
	{
		//add test cases		
		MonsterPQ myPQ = new MonsterPQ();
		Monster frank = new Monster(1,1,1);
		Monster jill = new Monster(2,2,2);
		Monster bob = new Monster(3,3,3);
		myPQ.add(bob);
		myPQ.add(jill);
		myPQ.add(frank);
		System.out.println(myPQ.getMin());
		System.out.println(myPQ.removeMin());
		System.out.println(myPQ.getMin());
		System.out.println(myPQ.removeMin());
		System.out.println(myPQ.removeMin());		
	}
}