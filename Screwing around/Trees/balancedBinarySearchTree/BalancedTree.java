package balancedBinarySearchTree;

import binarySearchTree.*;

public class BalancedTree extends BinarySearchTree{

	public BalancedTree(int[] data){
		setRoot(balance(data));
	}
	
	public TreeNode balance(int[] arr){
		return balance(arr,0,arr.length-1);
	}
	
	public TreeNode balance(int[] arr, int min, int max){
		if(min > max)
			return null;
		
		int middle = (min+max)/2;
		
		TreeNode node = new TreeNode(arr[middle], null, null);
		
		node.setLeft(balance(arr, min, middle-1));
		node.setRight(balance(arr, middle+1, max));
		return node;
	}

}
