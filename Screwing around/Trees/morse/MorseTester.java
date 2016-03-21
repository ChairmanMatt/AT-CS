package morse;

import java.util.Scanner;

import binarySearchTree.*;

public class MorseTester {

	public static void main(String[] args){
		BinarySearchTree bsTree = new BinarySearchTree();
		String letters = "0_9O.8M Q G Z7T Y K C N X D B6/1J W P A R L E2- U F I3V S4H5";

		bsTree.add(new Morse(-1, ' '));

		for(int x = letters.indexOf("/")-1; x > 0; x--){
			bsTree.add(new Morse(x, letters.charAt(x)));
			System.out.println(x);
		}

		for(int x = letters.indexOf("/")+1; x<letters.length(); x++){
			bsTree.add(new Morse(x, letters.charAt(x)));
			System.out.println(x);
		}

		System.out.println("DONE ADDING");
		
		System.out.println(bsTree);
	}

}
