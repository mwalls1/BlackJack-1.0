package Interfaces;

import static java.lang.System.*;

import java.util.ArrayList;

public class Word implements Comparable<Word> {
	// add an instance variable and a constructor
	// private ArrayList<String> words = new ArrayList<String>();
	private String word = "";

	public Word(String w) {
		word = w;
	}

	// add a compareTo
	public int compareTo(Word other) {
		if (this.word.length() > other.word.length()) {
			return 1;
		} else if (this.word.length() < other.word.length()) {
			return -1;
		} else
			return this.word.compareTo(other.word);
	}

	public void setString(String a) {
		word = a;
	}

	// add a toString
	public String toString() {
		return word;
	}
}