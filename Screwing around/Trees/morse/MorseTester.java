package morse;

import java.util.Scanner;

import binarySearchTree.TreeNode;

public class MorseTester {

	MorseBalancedTree bsTree;
	static final String LETTERS = "0_9O. 8M Q G Z7T Y K C N X D B6/1J W P A   R L E2- U F I3V S4H5";
	
	
	public static void main(String[] args){

		MorseTester mt = new MorseTester();

		Morse[] more = new Morse[63];
		for(int x = 0; x<LETTERS.length(); x++){
			more[x] = new Morse(x, LETTERS.charAt(x));
		}
		mt.bsTree = new MorseBalancedTree(more);

		System.out.println(mt.bsTree);

		System.out.println(mt.toEng(".... . .-.. .-.. --- .-- --- .-. .-.. -.."));
		mt.findMorse('C');
		
	}

	public String toEng(String str){
		TreeNode node;

		String eng = "";
		String[] parts = str.split(" ");

		for(int x = 0; x < parts.length; x++){
			node = bsTree.root();

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

//	public String toMorse(String str){
//		String morse = "";
//		
//		String[] parts = str.split(" ");
//		for(int x = 0; x< parts.length; x++){
//			String p = parts[x];
//			for(int a = 0; a < p.length(); a++){
//				
//			}
//			
//		}
//		
//	}
	
	public void findMorse(char c){
		String toRet = "";
		Morse mo = new Morse(LETTERS.indexOf(c+""),c);
		
		TreeNode t = bsTree.search(c);
		
//		return toRet;
	}
	
}
