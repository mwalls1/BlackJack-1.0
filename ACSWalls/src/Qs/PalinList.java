package Qs;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PalinList {
	private Queue<String> queue;
	private Stack<String> stack;
	private String words = "";

	public PalinList() {
		setList("");
	}

	public PalinList(String list) {
		queue = new LinkedList<String>();
		stack = new Stack<String>();
		for (String s : list.split(" ")) {
			queue.add(s);
			stack.push(s);
			words += s + " ";
		}
	}

	public void setList(String list) {
		words = "";
		stack.removeAllElements();
		queue.clear();
		for (String s : list.split(" ")) {
			queue.add(s);
			stack.push(s);
			words += s + " ";
		}
	}

	public boolean isPalin() {

		while (!stack.isEmpty() && !queue.isEmpty()) {
			if (!(stack.pop().equals(queue.poll()))) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		if (isPalin()) {
			return words + "is a PalinList";
		} else
			return words + "is not a PalinList";
	}
}

// write a toString method
