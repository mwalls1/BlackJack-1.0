package lab04;
//Name -

//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class NameChanger {
	String first = "";
	String last = "";
	int firstt;
	int[] asci;
	char[] charr;

	public NameChanger(String f, String l) {
		first = f;
		last = l;
		charr = new char[first.length() - 1];
		asci = new int[first.length() - 1];

		for (int i = 0; i < first.length() - 1; i++) {
			charr[i] = first.charAt(i);
			asci[i] = (int) charr[i];
			firstt += asci[i];
		}

	}

	public void scramble() {
		last = last.replace(last.charAt(last.length() - 1), 'z');
	}

	public void setNames(String f, String l) {
		first = f;
		last = l;
	}

	public void reverse() {
		String temp = "";
		String tempp = "";
		for (int i = first.length() - 1; i >= 0; i--) {
			temp += first.substring(i, i + 1);
		}
		first = temp;
		tempp += last.substring(last.length() / 2);
		tempp += last.substring(0, last.length() / 2);
		last = tempp;

	}

	public String toString() {
		String out = "";
		for (int i = 0; i < asci.length; i++) {
			System.out.print(asci[i]);
		}
		out += "\n\nLast name: " + last;
		return out;
	}

}
