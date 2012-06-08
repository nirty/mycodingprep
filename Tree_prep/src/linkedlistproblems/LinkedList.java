package linkedlistproblems;

public class LinkedList {

	Node root;
	
	LinkedList(){
		root = null;
	}
	
	public boolean isEmpty() {
        return root == null;
	}
	
	 public void insert(String word, int val) {
         Node node = new Node(word, val);
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
	 
	 public void rotate(int positions){
		 
		 Node rootnode = root;
		 Node current = root;
		 Node previous = null;
		 while(positions>0){
			 previous = current;
			 current = current.next;
			 positions--;
		 }
		 
		 previous.next = null;
		 root = current;
		 
		 while(current.next!=null)
			 current = current.next;
		 
		 current.next = rootnode;		 
	 }
	 
	 public void Sort(){
		 // bubble and mergesort - 
		 root = merge_sort(root);
	 }
	 
	 public void BubbleSort(){
		 // bubble and mergesort - 
		// root =  bubbleSort_values(root);
		 root = bubbleSort_swaps(root);
	 }
	
	 public Node bubbleSort_swaps(Node root){
		 
		 
		 while(root == null|| root.next == null)
			 return root;
		
		 boolean swapped = true;
		 
		 while(swapped == true){
		 Node previous = null;
		 Node current = root;
		 Node nextt = root.next;
		 
		 
		swapped = false;
		 
		 while(nextt!=null){
			 
			 if(current.intval>nextt.intval){
				 
				 swapped = true;
				 if(current == root){	
					 //TODO Draw this.
					 Node temp;				 
					 root = nextt;
				     temp = nextt.next;
				     nextt.next = current;
				     current.next = temp;
				     current = root;
				 }else
				 {
					 //TODO Draw this.
		                previous.next = current.next;
		                current.next = nextt.next;
		                nextt.next = current;
		                current = nextt;
				 }
			 }
			 
			 previous = current;
			 current = current.next;
			 nextt = current.next;
			
		 }
		}
		 
		 return root;
	 }
	 
	 public Node bubbleSort_values(Node node){
		 
		 if(node== null || node.next== null)
			 return node;
		 
		 
		 Node curNode = node;

		 
		 while(curNode.next!=null){
			 
			 Node itrNode = curNode.next;
			 while(itrNode!=null){
				 
				 if(curNode.intval>=itrNode.intval)
				 {
					 swap(curNode,itrNode);
				 }
				 
				 itrNode = itrNode.next;
			 }
			 
			 curNode = curNode.next;
			 
		 }
		 
		 return node;
	 }
	 

	 
	private void swap(Node curNode, Node itrNode) {
		
		int temp = itrNode.intval;
		itrNode.intval = curNode.intval;
		curNode.intval = temp;
		
		String tempstr = itrNode.value;
		itrNode.value = curNode.value;
		curNode.value = tempstr;
		
	}

	//The recursive merge sort
	 public Node merge_sort(Node head) {
	     if(head == null || head.next == null) { return head; }
	     Node middle = getMiddle(head);      //get the middle of the list
	     Node sHalf = middle.next; middle.next = null;   //split the list into two halfs

	     return merge(merge_sort(head),merge_sort(sHalf));  //recurse on that
	 }

	 //Merge subroutine to merge two sorted lists
	 public Node merge(Node a, Node b) {
	     Node dummyHead, curr; 
	     dummyHead = new Node("dummy",-1);
	     curr = dummyHead;
	     while(a !=null && b!= null) {
	         if(a.intval <= b.intval) { 
	        	 curr.next = a; 
	        	 a = a.next; 
	         	}
	         else {
	        	 curr.next = b;
	        	 b = b.next;
	        }
	         curr = curr.next;
	     }
	     curr.next = (a == null) ? b : a;
	     return dummyHead.next;
	 }

	 //Finding the middle element of the list for splitting
	 public Node getMiddle(Node head) {
	     if(head == null) { return head; }
	     Node slow, fast; slow = fast = head;
	     while(fast.next != null && fast.next.next != null) {
	         slow = slow.next; fast = fast.next.next;
	     }
	     return slow;
	 }
}


