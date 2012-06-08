package linkedlistproblems;

public class Problems {

	
	public static void main(String args[]){
		
		LinkedList list = new LinkedList();
		list.insert("one");
		list.insert("two");
		list.insert("three");
		list.insert("four");
		list.insert("five");
		list.PrintList();
		System.out.println("REcursive:");
		list.recursivereverse();
		list.PrintList();
		System.out.println("Iterative:");
		list.iterativereverse();
		list.PrintList();
	}
	
	
	
}
