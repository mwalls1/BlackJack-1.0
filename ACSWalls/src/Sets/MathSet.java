package Sets;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

import java.io.File;
import java.io.FileNotFoundException;

public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;

	public MathSet()
	{
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
	}

	public MathSet(String o, String t)
	{
		Scanner scan  = new Scanner(o);
		while (scan.hasNextInt()) {
			one.add(scan.nextInt());
		}
		Scanner sca  = new Scanner(t);
		while (sca.hasNextInt()) {
			two.add(sca.nextInt());
		}

	}

	public Set<Integer> union()
	{
		Set<Integer> oo = new TreeSet<Integer>();
		oo.addAll(one);
		oo.addAll(two);
		return oo;
		
	}

	public Set<Integer> intersection()
	{
		Set<Integer> oo = new TreeSet<Integer>(one);
		oo.retainAll(two);
		return oo;
	}

	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> oo = new TreeSet<Integer>(one);
		oo.removeAll(two);
		return oo;
	}

	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> oo = new TreeSet<Integer>(two);
		oo.removeAll(one);
		return oo;
	}
	
	public Set<Integer> symmetricDifference()
	{		
		Set<Integer> intersection = new TreeSet<Integer>(one);
		intersection.retainAll(two);

		Set<Integer> difference = new TreeSet<Integer>();
		difference.addAll(one);
		difference.addAll(two);
		difference.removeAll(intersection);
		return difference;
	}	
	
	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n"+"union - "+union()+"\n"+"intersection - "+intersection()+"\n"+"Difference A-B - "+differenceAMinusB()+"\n"+"Difference B-A - "+differenceBMinusA()+"\n"+"Symmetric Difference - "+symmetricDifference();
	}
}