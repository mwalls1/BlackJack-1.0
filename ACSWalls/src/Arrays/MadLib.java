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

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	public MadLib()
	{
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();


	}

	public MadLib(String fileName)
	{
		//load stuff
		
		
		
		try{
			Scanner file = new Scanner(new File(fileName));
			
		
		
		
		
		
		
	
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try{
		Scanner noun = new Scanner("data/nouns.dat");
		while(noun.hasNext())
		{
			nouns.add(noun.next());
		}
		
		
		
		}
		catch(Exception e)
		{
			System.out.println("nouns no load");
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
		Scanner verb = new Scanner("data/verbs.dat");
		while(verb.hasNext())
		{
			nouns.add(verb.next());
		}
	
	
	
		}
		catch(Exception e)
		{
			System.out.println("verbs no load");
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner adjective = new Scanner("data/adjectives.dat");
			while(adjective.hasNext())
			{
				nouns.add(adjective.next());
			}
	
	
	
		}
		catch(Exception e)
		{
			System.out.println("Adjectives no load");
		}
	}

	public String getRandomVerb()
	{
	
		return verbs.get((int)Math.random()+verbs.size());
	}
	
	public String getRandomNoun()
	{
		
		return "";
	}
	
	public String getRandomAdjective()
	{
		
		return "";
	}		

	public String toString()
	{
	   return "\n\n\n";
	}
}