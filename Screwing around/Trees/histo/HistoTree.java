package histo;

import binarySearchTree.TreeNode;

public class HistoTree
{
	private HistoNode root;

	public HistoTree( )
	{
		root = null;
	}

	public void addData(Comparable data)
	{
		if(root != null)
			add(data, root);
		else
			root = new HistoNode(data, 1, null, null);
	}

	private HistoNode add(Comparable data, HistoNode tree)
	{
		if(tree == null){
			tree = new HistoNode(data, 1, null, null);
			return tree;
		}

		int dirTest = data.compareTo(tree.getData());

		if(dirTest < 0)
			tree.setLeft(add(data, tree.getLeft()));

		else if(dirTest > 0)
			tree.setRight(add(data, tree.getRight()));

		else
			tree.setDataCount(tree.getDataCount() + 1);

		return tree;
	}

	public HistoNode search(Comparable data)
	{
		HistoNode ht = search(data, root);

		if(ht != null)
			return search(data, root);
		
		return new HistoNode(data + " not found", 0, null, null);
	}

	private HistoNode search(Comparable data, HistoNode tree)
	{
		if(tree == null)
			return null;

		int dirTest = data.compareTo(tree.getData());

		if(dirTest < 0)
			return search(data, tree.getLeft());

		if(dirTest > 0)
			return search(data, tree.getRight());

		else
			return tree;
	}

	public String toString()
	{

		return toString(root);
	}

	private String toString(HistoNode tree)
	{
		if(tree == null)
			return "";

		return tree.getData().toString() + ", " + tree.getDataCount() + " | " + toString(tree.getLeft()) + toString(tree.getRight());
	}
}