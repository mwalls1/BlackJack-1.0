package Nodes;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.*;
import static java.lang.System.*;

public class HistoList {
	private HistoNode front;

	public HistoList() {
		front = null;
	}

	// addLetter will add a new node to the front for let if let does not exist
	// addLetter will bump up the count if let already exists
	public void addLetter(char let) {
		if (indexOf(let) == -1) {
			front = new HistoNode(let, 1, front);
		} else {
			HistoNode current = nodeAt(indexOf(let));
			current.setLetterCount(current.getLetterCount() + 1);

		}
	}

	// returns the index pos of let in the list if let exists
	public int indexOf(char let) {
		HistoNode current = front;
		int count = -1;
		while (current != null) {
			count++;
			if (current.getLetter() == let)
				
				return count;
			else
				current = current.getNext();
			
		}

		return -1;

	}

	// returns a reference to the node at spot
	private HistoNode nodeAt(int spot) {
		HistoNode current = front;
		for (int i = 0; i < spot; i++) {
			current = current.getNext();
		}
		return current;
	}

	// returns a string will all values from list
	public String toString() {
		String output = "";
		HistoNode current = front;
		while (current != null) {
			output += current.getLetter()+": "+current.getLetterCount()+"\n";
			current = current.getNext();
		}
		return output;
	}
}