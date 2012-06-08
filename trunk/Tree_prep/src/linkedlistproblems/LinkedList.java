package linkedlistproblems;

public class LinkedList {

	Node root;
	
	LinkedList(){
		root = null;
	}
	
	public boolean isEmpty() {
        return root == null;
	}
	
	 public void insert(String word) {
         Node node = new Node(word);
         Node temp = root;
         if(root == null)
        	 root = node;
         else{
         while(temp.next !=null)
        	 temp = temp.next;
         temp.next = node;
         }
	 }
	 
	 
	 public void PrintList(){
		 Node temp = root;
		 if(root == null)
        	System.out.println("null");
         else{
        	 System.out.print(temp.value + " --> ");
        	 while(temp.next !=null){        		 
        		 temp = temp.next;     
        		 System.out.print(temp.value + " --> ");
        	 }
        	 System.out.println("null");
         }
	 }
	 
	 public void recursivereverse(){		
		root = reverse(root, null);
	 }
	 
	 public Node recurse(Node node){
		 if(node == null || node.next == null)
			 return node;
		 
		 Node end = recurse(node.next);
		 
		 System.out.println("End - "+ end.value);
		 Node curr = end;
		 
		 System.out.println("Curr= "+ curr.value);
		 
		 while(curr.next!=null)
			 curr = curr.next;
		 
		 curr.next = node;
		 System.out.println("Next of current" +curr.next.value);
		 
		 node.next = null;
		 
		 return end;
		 
	 }
	 
	 
	 public Node  reverse( Node current , Node previous)
	 {
	     Node temp;
	     if(current.next == null) {
	         current.next = previous;
	         return current;
	     } else {
	         temp = reverse(current.next, current);
	         current.next = previous;
	         return temp;
	     }
	 }
	 
	public Node reverse_itr( Node ptr)
	 {
	     Node temp;
	     Node previous = null;
	     while(ptr != null) {
	         temp = ptr.next;
	         ptr.next = previous;
	         previous = ptr;
	         ptr = temp;
	     }
	     return previous;
	 }
	 
	 public void iterativereverse(){		 
		 root = reverse_itr(root);
	 }
	 
	 public void insertAt(String word, int position){
		 
	 }
	 
	 public void insertSorted(String word){
		 
	 }
	 
	 public void deleteAt(int position){
		 
	 }
	 
	 public void swapVal(int loc1, int loc2){
		 
	 }
	 
	 public void swapPtrs(int loc1, int loc2){
		 
	 }
	 
	 public void deleteduplicatesUnsorted(){ // cracking the coding interview
		 
	 }
	 
	 public void deleteduplicatesSorted(){ // - crack the interview
		 
	 }
	 
	 public Node detectloop(){
		 
		 return null;
	 }
	 
	 public void removeloop(){
		 
	 }
	 
	 public void Sort(){
		 // bubble and mergesort 
	 }
}


