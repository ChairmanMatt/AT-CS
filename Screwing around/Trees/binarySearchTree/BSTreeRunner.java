package binarySearchTree;

import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
 		BinarySearchTree bt = new BinarySearchTree();
 		bt.add(new Integer(7));
 		bt.add(new Integer(1));
 		bt.add(new Integer(0));
 		bt.add(new Integer(3));
 		bt.add(new Integer(2));
 		bt.add(new Integer(5));
 		bt.add(new Integer(4));
 		bt.add(new Integer(6));
 		bt.add(new Integer(9));
 		bt.add(new Integer(8));
 		bt.add(new Integer(10));
 		
 		bt.inOrder();
 		bt.preOrder();
 		bt.postOrder();
 		bt.revOrder();
   }
}