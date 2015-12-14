package Arrays;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib {
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private String sentence;

	public MadLib() {
		sentence = "";

	}

	public MadLib(String fileName) {
		// load stuff
		this();
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		
		loadAdjectives();
		loadNouns();
		loadVerbs();

		try {
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext()) {
				String word = file.next();
				if (word.equals("#"))
					sentence += getRandomNoun() + " ";
				else if (word.equals("@"))
					sentence += getRandomVerb() + " ";
				else if (word.equals("&"))
					sentence += getRandomAdjective() + " ";
				else
					sentence += word + " ";
			}
		} catch (Exception e) {
			out.println(e);
		}

	}

	public void loadNouns() {
		try {
			Scanner noun = new Scanner("data/nouns.dat");
			while (noun.hasNext()) {
				nouns.add(noun.next());
			}

		} catch (Exception e) {
			System.out.println("nouns no load");
		}

	}

	public void loadVerbs() {
		try {
			Scanner verb = new Scanner("data/verbs.dat");
			while (verb.hasNext()) {
				verbs.add(verb.next());
			}

		} catch (Exception e) {
			System.out.println("verbs no load");
		}
	}

	public void loadAdjectives() {
		try {
			Scanner adjective = new Scanner("data/adjectives.dat");
			while (adjective.hasNext()) {
				adjectives.add(adjective.next());
			}

		} catch (Exception e) {
			System.out.println("Adjectives no load");
		}
	}

	public String getRandomVerb() {

		return verbs.get((int) Math.random() + verbs.size());
	}

	public String getRandomNoun() {

		return nouns.get((int) Math.random() + nouns.size());
	}

	public String getRandomAdjective() {

		return adjectives.get((int) Math.random() + adjectives.size());
	}

	public String toString() {
		return sentence + "\n\n\n";
	}
}