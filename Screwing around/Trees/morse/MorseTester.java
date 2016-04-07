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

		System.out.println(mt.bsTree.morseToEng(".... . .-.. .-.. --- .-- --- .-. .-.. -.."));
		System.out.println(mt.bsTree.engToMorse("HELLO WORLD"));
		
	}

	
	
}
