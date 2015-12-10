package Arrays;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ArrayListFunHouse {
	/*
	 * method getListOfFactors will return a list of all of the factors of
	 * number - excluding number
	 */
	public static ArrayList<Integer> getListOfFactors(int number) {
		if (number % 2 == 0) {
			System.out.println(number + " is even.");
		} else
			System.out.println(number + " is odd.");
		int perf = 0;
		ArrayList<Integer> divs = new ArrayList<Integer>();
		for (int i = 1; i < number; i++) {
			int num = number % i;
			if (num == 0) {
				divs.add(new Integer(i));
			}

		}
		for (int j = 0; j < divs.size(); j++) {
			perf += divs.get(j);
		}
		if (perf == number) {
			System.out.println(number + " is perfect.");
		} else
			System.out.println(number + " is not perfect");
		return divs;
	}
}