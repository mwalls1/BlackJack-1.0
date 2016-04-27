package Trees;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
 		//add test cases here
 		BinarySearchTree tree = new BinarySearchTree();
 		tree.add(90);
 		tree.add(100);
 		tree.add(80);
 		tree.add(70);
 		tree.add(85);
 		tree.add(98);
 		tree.add(120);
 		tree.inOrder();
 		tree.preOrder();
 		tree.postOrder();
 		tree.reverse();
 		
 		
 		
 		
 		
 
   }
}