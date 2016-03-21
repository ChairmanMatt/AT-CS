package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public TreeNode root(){
		return root;
	}
	
	public void setRoot(TreeNode t){
		root = t;
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
			System.out.print(tree.getValue() + " | ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder(){
		System.out.println("PRE");
		System.out.print(root.getValue()+ " | ");
		preOrder(root.getLeft());
		preOrder(root.getRight());

		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree){
		if(tree != null){
			System.out.print(tree.getValue() + " | ");
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
			System.out.print(tree.getValue() + " | ");
		}
	}


	public void revOrder()
	{
		System.out.println("REV ORDER");
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree)
	{
		if (tree != null){
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " | ");
			revOrder(tree.getLeft());
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
			return isFull(tree.getLeft()) && isFull(tree.getRight());

		return false;

	}

	public void search(Comparable c){
		System.out.println("SEARCH FOR " + c.toString() + "\n" + search(root, c)+"\n");
//		if(search(root, c))
			
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
		System.out.println("LEVEL ORDER");

		Queue<Comparable> q = new LinkedList<Comparable>();
		q.add(root.getValue());

		levelOrder(root, q);

		System.out.println(q);

		System.out.println("\n\n");		
	}

	private void levelOrder(TreeNode tree, Queue<Comparable> list){
		if(tree == null)
			return;
		if(tree.getLeft() != null)
			list.add(tree.getLeft().getValue());

		if(tree.getRight() != null)
			list.add(tree.getRight().getValue());

		levelOrder(tree.getLeft(), list);

		levelOrder(tree.getRight(), list);
	}

	public void remove(Comparable val){
		root = remove(val, root);
	}

	private TreeNode remove(Comparable val, TreeNode tree){
		if(tree != null){
			int dirTest = val.compareTo(tree.getValue());

			if(dirTest < 0)
				tree.setLeft(remove(val, tree.getLeft()));
			else if (dirTest > 0)
				tree.setRight(remove(val, tree.getRight()));
			else{
				if(tree.getRight() == null)
					tree = tree.getLeft();
				else{
					TreeNode successor = getSmallest(tree.getRight());
					tree.setValue(successor.getValue());
					tree.setRight(remove(successor.getValue(), tree.getRight()));
				}
			}
		}

		return tree;
	}

	private TreeNode getSmallest(TreeNode tree){
		if(tree.getLeft() == null)
			return tree;

		return tree.getLeft();
	}

	public String toString()
	{
		String str = "";
		for(int x = 0; x<getNumLevels(root); x++){
			str += toString(root, x+1);
			str+="\n";
			
		}

		return str;
	}

	private String toString(TreeNode tree, int level)
	{
		if(tree == null)
			return "";

		if(level == 1)
			return tree.getValue().toString() + " | "; 

		return toString(tree.getLeft(), level-1) + toString(tree.getRight(), level-1);
	}
}