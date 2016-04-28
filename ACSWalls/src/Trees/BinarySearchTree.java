package Trees;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;
import java.util.LinkedList;

public class BinarySearchTree {
	private int count;
	int counts;
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null)
			tree = new TreeNode(val);

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);

		if (dirTest < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	// add preOrder, postOrder, and revOrder
	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());

		}
	}
	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}
	public void reverse() {
		reverse(root);
		System.out.println("\n\n");
	}

	private void reverse(TreeNode tree) {
		if (tree != null) {
			reverse(tree.getRight());
			System.out.print(tree.getValue() + " ");
			reverse(tree.getLeft());
		}
	}

	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight()))
			return 1 + getNumLevels(tree.getLeft());
		else
			return 1 + getNumLevels(tree.getRight());
	}

	// add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull
	public void numNodes() {
		numNodes(root);
		System.out.println(count);
	}

	private void numNodes(TreeNode tree) {
		if (tree != null) {
			count++;
			numNodes(tree.getLeft());
			numNodes(tree.getRight());
		}
	}
	public void numLeaves()
	{
		numLeaves(root);
		System.out.println(counts);
	}
	private void numLeaves(TreeNode tree)
	{
		if(tree!=null)
		{
			if(tree.getLeft()==null&&tree.getRight()==null)
			{
				counts++;
			}
			else
			{
				numLeaves(tree.getLeft());
				numLeaves(tree.getRight());
			}
		}
	}
	public void height()
	{
		System.out.println(height(root)-1);
	}
	public int height(TreeNode tree)
	{
		
	    if (tree != null)
	    {;
	        return 1+Math.max(height(tree.getLeft()),height(tree.getRight()));
	    }
	    else return 0;
	    
	}
	private int getMaxWidth(TreeNode tree)
	{
	  int maxWidth = 0;   
	  int width;
	  int h = height(tree);
	  int i;
	   
	  /* Get width of each level and compare 
	     the width with maximum width so far */
	  for(i=1; i<=h; i++)
	  {
	    width = getWidth(tree, i);
	    if(width > maxWidth)
	      maxWidth = width;
	  }     
	   
	  return maxWidth;
	}
	public void getWidth()
	{
		System.out.println(getMaxWidth(root)+1);
	}
	private int getWidth(TreeNode tree, int level)
	{
	     
	  if(tree == null)
	    return 0;
	   
	  if(level == 1)
	    return 1;
	             
	  else
	    return getWidth(tree.getLeft(), level-1) + 
	             getWidth(tree.getRight(), level-1);
	}
	public void isFull()
	{
		System.out.println(isFull(root));
	}
	private boolean isFull (TreeNode tree)
		{
		    // If empty tree
		    if (root == null)
		        return true;
		 
		    // If leaf node
		    if (tree.getLeft() == null && tree.getRight() == null)
		        return true;
		 
		    // If both left and right are not NULL, and left & right subtrees
		    // are full
		    if ((tree.getLeft()!=null) && (tree.getRight()!=null))
		        return (isFull(tree.getLeft()) && isFull(tree.getRight()));
		 
		    // We reach here when none of the above if conditions work
		    return false;
		}
	// add extra credit options here - 10 points each

	// search

	// maxNode

	// minNode

	// level order

	// display like a tree

	// remove

	public String toString() {
		return "";
	}

	private String toString(TreeNode tree) {
		return "";
	}
}