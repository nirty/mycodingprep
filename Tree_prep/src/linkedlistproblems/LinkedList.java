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
		 
	 }
	 
	 public void iterativereverse(){
		 
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


