package Nodes;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.*;
import static java.lang.System.*;

public class ListFunHouseRunner
{
	public static void main ( String[] args )
	{
		ListNode z = new ListNode("0",
			 			new ListNode("1",
		      		new ListNode("2",
		       		new ListNode("3",
			 			new ListNode("4",
		      		new ListNode("5",
		       		new ListNode("6",		       		
			 			new ListNode("7",null))))))));
			 			
		out.println("Lab15b Test Code\n\n");	
		
		out.println("Original list values\n");	
		ListFunHouse.print(z);
		out.println("\n");
		
		out.println("num nodes = " + ListFunHouse.nodeCount(z));

		out.println("\nList values after calling nodeCount\n");	
		ListFunHouse.print(z);
		out.println();		

		ListFunHouse.doubleFirst(z);		
		out.println("\nList values after calling doubleFirst\n");							
		ListFunHouse.print(z);
		out.println();	 

		ListFunHouse.doubleLast(z);		
		out.println("\nList values after calling doubleLast\n");							
		ListFunHouse.print(z);
		out.println();				
				
		ListFunHouse.removeXthNode(z,2);		
		out.println("\nList values after calling removeXthNode(2)\n");					
		ListFunHouse.print(z);
		out.println();			
				
		ListFunHouse.setXthNode(z,2,"one");		
		out.println("\nList values after calling setXthNode(2,one)\n");										
		ListFunHouse.print(z);
		out.println();				
	}
}