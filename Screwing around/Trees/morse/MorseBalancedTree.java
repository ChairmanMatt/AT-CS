package morse;

import binarySearchTree.*;

public class MorseBalancedTree extends BinarySearchTree{

	
	public MorseBalancedTree(Morse[] data){
		setRoot(balance(data));
	}

	public TreeNode balance(Morse[] arr){
		return balance(arr,0,arr.length-1);
	}
	

	public TreeNode balance(Morse[] arr, int min, int max){
		if(min > max)
			return null;
		
		int middle = (min+max)/2;
		
		TreeNode node = new TreeNode(arr[middle], null, null);
		
		node.setLeft(balance(arr, min, middle-1));
		node.setRight(balance(arr, middle+1, max));
		return node;
	}

	
	public TreeNode search(char c){
		return search(root(), c);
	}
	
	public TreeNode search(TreeNode tree, char c){
		if(tree == null)
			return null;
		
		if(((Morse)tree.getValue()).getLetter()==c)
			return tree;
			
		if (search(tree.getLeft(), c) != null)
			return tree.getLeft();
		
		if(search(tree.getRight(), c) != null)
			return tree.getRight();
		
		return null;
	}

	
	public String toEng(String str){
		
		
	}
	
}
