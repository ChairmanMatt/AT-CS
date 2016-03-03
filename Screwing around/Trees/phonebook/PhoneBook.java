package phonebook;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import binarySearchTree.*;

public class PhoneBook extends BinarySearchTree{
	
	public PhoneBook() throws FileNotFoundException{
		super();
		
		File file = new File("C:/Users/CMS-1/Documents/phone2.dat");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()){
			add(new PhoneEntry(sc.nextLine()));
		}
		
		sc.close();
	}
	
	public void add(PhoneEntry a){
		super.add(a);
	}
	
	public void display(){
		super.inOrder();
	}
	
	public String lookUp(String name){
		TreeNode root = root();
		PhoneEntry result = (PhoneEntry) lookUp(root, name).getValue();
	
		return result.getNumber();
	}
	
	private TreeNode lookUp(TreeNode tree, String name){
		if(tree == null)
			return null;

		PhoneEntry pe = (PhoneEntry) tree.getValue();
		
		if(pe.getName().equals(name))
			return tree;

		if(lookUp(tree.getLeft(), name) != null)
			return lookUp(tree.getLeft(), name);
		
		return lookUp(tree.getRight(), name);
	}
	
	public String revLookUp(String number){
		TreeNode root = root();
		PhoneEntry result = (PhoneEntry) revLookUp(root, number).getValue();
	
		return result.getName();
	}
	
	private TreeNode revLookUp(TreeNode tree, String number){
		if(tree == null)
			return null;

		PhoneEntry pe = (PhoneEntry) tree.getValue();
		
		if(pe.getNumber().equals(number))
			return tree;

		if(revLookUp(tree.getLeft(), number) != null)
			return revLookUp(tree.getLeft(), number);
		
		return revLookUp(tree.getRight(), number);
	}
	
	public void delete(String name){
		PhoneEntry p = (PhoneEntry) lookUp(root(),name).getValue();
		
		remove(p);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		PhoneBook p = new PhoneBook();
		p.display();
		
		System.out.println(p.lookUp("Shataka"));
		System.out.println(p.revLookUp("8810712"));
		
		p.delete("Shataka");
		
		p.display();
	}
	
}
