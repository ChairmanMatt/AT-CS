package binarySearchTree;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
		if(tree == null){
			tree = new TreeNode(val);
			return tree;
		}
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);


		if(dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));

		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder()
	{
		System.out.println("IN ORDER");
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder(){
		System.out.println("PRE");
		System.out.print(root.getValue()+ " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());

		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree){
		if(tree != null){
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}

	}

	public void postOrder(){
		System.out.println("POST");
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree){
		if(tree != null){
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}


	public void revOrder()
	{
		System.out.println("REV ORDER");
		inOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getLeft());
		}
	}

	public void getNumLevels()
	{
		System.out.println("GET NUM LEVELS: \n" + getNumLevels(root) + "\n");
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
			return 1+getNumLevels(tree.getLeft());
		else
			return 1+getNumLevels(tree.getRight());
	}

	public void getHeight(){
		System.out.println("GET HEIGHT: \n"+ (getNumLevels(root)-1) + "\n");
	}

	//add getNumNodes, and isFull

	public void getNumLeaves(){
		System.out.println("GET NUM LEAVES: \n" + (getNumLeaves(root) / 2) +"\n");
	}

	private int getNumLeaves(TreeNode tree){
		if(tree == null)
			return 1;

		return(getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight()));
	}

	public void getWidth(){
		System.out.println("GET WIDTH: \n" + (getWidth(root) + 1) +"\n");
	}

	private int getWidth(TreeNode tree){
		if(tree == null)
			return 1;

		if(getWidth(tree.getLeft()) > getWidth(tree.getRight()))
			return getWidth(tree.getLeft()) + 1;

		return getWidth(tree.getRight()) + 1;
	}

	public void getNumNodes(){
		System.out.println("GET NUM NODES: \n" + getNumNodes(root) +"\n");
	}

	private int getNumNodes(TreeNode tree){
		if(tree == null)
			return 0;

		return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
	}

	public void isFull(){
		System.out.println("IS FULL: \n" + isFull(root) +"\n");
	}

	private boolean isFull(TreeNode tree){
		if(tree.getLeft() == null && tree.getRight() == null)
			return true;

		if(tree.getLeft() != null && tree.getRight() != null)
			return isFull(tree.getLeft()) || isFull(tree.getRight());

		return false;

	}

	public void search(Comparable c){
		System.out.println("SEARCH FOR " + c.toString() + "\n" + search(root, c)+"\n");

	}

	private boolean search(TreeNode tree, Comparable c){
		if(tree == null)
			return false;


		if(tree.getValue().equals(c))
			return true;

		return (search(tree.getLeft(), c) || search (tree.getRight(), c));


	}

	public void maxNode(){
		System.out.println("MAX NODE: \n"+maxNode(root, root.getValue())+"\n");

	}

	private Comparable maxNode(TreeNode tree, Comparable c){
		if(tree == null)
			return c;

		if(tree.getValue().compareTo(c) > 0)
			return maxNode(tree.getRight(), tree.getValue());

		return maxNode(tree.getRight(), c);
	}

	public void minNode(){
		System.out.println("MIN NODE: \n"+minNode(root, root.getValue())+"\n");

	}

	private Comparable minNode(TreeNode tree, Comparable c){
		if(tree == null)
			return c;

		if(tree.getValue().compareTo(c) < 0)
			return minNode(tree.getLeft(), tree.getValue());

		return minNode(tree.getLeft(), c);
	}

	//level order
	public void levelOrder(){

	}

	private TreeMap<Integer, TreeSet<String>> levelOrder(TreeNode tree, TreeMap<Integer, TreeSet<String>> map){
		if(tree == null)
			return map;

		//you know how tall it is...how to find height from bottom?

		
		int x = getNumLevels(tree)-1;
		
		return levelOrder(tree.getLeft(), )


	}




	//display like a tree

	//remove


	public String toString()
	{
		return "";
	}

	private String toString(TreeNode tree)
	{
		return "";
	}
}