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
		return search(root(), c, "");
	}
	
	private String morse = "";
	
	private TreeNode search(TreeNode tree, char c, String s){
		if(tree == null)
			return null;
		
		if(((Morse)tree.getValue()).getLetter()==c){
			morse = s;
			return tree;
		}
			
		if (search(tree.getLeft(), c, s+"-") != null)
			return search(tree.getLeft(), c, s+"-");
		
		if(search(tree.getRight(), c, s+".") != null)
			return search(tree.getRight(), c, s+".");
		
		return null;
	}

	public String morseToEng(String str){
		TreeNode node;

		String eng = "";
		String[] parts = str.split(" ");

		for(int x = 0; x < parts.length; x++){
			node = root();

			String sc = parts[x];

			for(int s = 0; s< sc.length(); s++){
				if(sc.charAt(s)=='.')
					node = node.getRight();
				else if(sc.charAt(s)=='-')
					node = node.getLeft();
			}

			eng += node.toString();
		}
		return eng;
	}
	
	public String engToMorse(String str){
		String[] parts = str.toUpperCase().split(" ");
		
		String translated = "";
		
		for(int arrIn = 0; arrIn < parts.length; arrIn++){
			for(int strIn = 0; strIn < parts[arrIn].length(); strIn++){
				search(root(),parts[arrIn].charAt(strIn), "");
				translated+=morse + " ";
			}
		}
		
		return translated;
	}
	
}
