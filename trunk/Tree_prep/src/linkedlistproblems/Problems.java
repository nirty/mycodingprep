package linkedlistproblems;

public class Problems {

	
	public static void main(String args[]){
		
		LinkedList list = new LinkedList();
		list.insert("one",1);
		list.insert("two",2);
		list.insert("three",3);
		list.insert("four",4);
		list.insert("five",5);
		list.PrintList();
		System.out.println("REcursive:");
		list.recursivereverse();
		list.PrintList();
		System.out.println();
		System.out.println("Iterative:");
		list.iterativereverse();
		list.PrintList();
		System.out.println();
		System.out.println("rotate 3 positions:");
		list.rotate(2);
		list.PrintList();
		System.out.println();
		System.out.println("Sort Back - Recursive MergeSort:");
		list.Sort();
		list.PrintList();
		System.out.println();
		System.out.println("rotate 4 positions:");
		list.rotate(4);
		list.PrintList();
		System.out.println();
		System.out.println("Sort Back - BubbleSort:");
		list.BubbleSort();
		list.PrintList();
	}
	
	
	
}
