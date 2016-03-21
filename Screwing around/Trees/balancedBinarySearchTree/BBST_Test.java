package balancedBinarySearchTree;

import binarySearchTree.*;

public class BBST_Test {

	public static void main(String[] args){
		int[] data = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		BalancedTree x = new BalancedTree(data);
		System.out.println(x.toString());
		
		TreeNode temp = x.root();
		System.out.println("Right Branch");
		
		while(temp != null){
			System.out.println(temp + " ");
			temp = temp.getRight();
		}
	}
	
}
