package binarySearchTree;

public class BSTreeRunner
{
	public static void main( String args[] )
	{
		BinarySearchTree bt = new BinarySearchTree();
		bt.add(90);
		bt.add(80);
		bt.add(70);
		bt.add(85);
		bt.add(100);
		bt.add(98);
		bt.add(120);
		
		
//		bt.add(69);
//		bt.add(71);
//		bt.add(84);
//		bt.add(86);
//		bt.add(97);
//		bt.add(99);
//		bt.add(119);
//		bt.add(121);
		
		bt.inOrder();
		bt.preOrder();
		bt.postOrder();
		bt.revOrder();

		bt.getHeight();
		bt.getWidth();
		bt.getNumLeaves();
		bt.getNumNodes();
		bt.getNumLevels();
		bt.isFull();
		bt.search(120);
		bt.maxNode();
		bt.minNode();
		bt.levelOrder();
		
	
		
		System.out.println(bt.toString());
		System.out.println("AFTER REMOVING 120");
		bt.remove(120);
		
		System.out.println(bt.toString());
		
	}
}