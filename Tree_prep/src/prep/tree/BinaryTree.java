package prep.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class BinaryTree {

	private Node root;
	
	
	public BinaryTree(){
		root = null;
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	public boolean lookup(int data){ 
		return look(root,data);
	}
	
	private boolean look(Node node,int data){
		
		if(node == null)
			return false;
		
		if(node.getValue().getWeight()==data)
			return true;
		
		boolean findleft = look(node.getLeft(),data);
		boolean findright = look(node.getRight(),data);
		
		if(findleft||findright)
			return true;
		else 
			return false;
		
	}

	public void insert(Data d){		
		Node n = new Node(d, null, null);
		if(root == null)
			root = n;
		else
			insert(root,n);
	}
	
	public Node insert(Node parent, Node newnode){
		
		if(parent==null){			
			//return newnode;
		}
		else if(newnode.getValue().getWeight()<=parent.getValue().getWeight()){
			if(parent.left ==null)
				parent.left = insert(parent.getLeft(),newnode);
			else
				insert(parent.getLeft(),newnode);
		}
		else if(newnode.getValue().getWeight()>parent.getValue().getWeight()){
			
			if(parent.right ==null)
				parent.right = insert(parent.getRight(),newnode);
			else
				insert(parent.getRight(),newnode);
		}	
		
		return newnode;
	}
	
	public void build(ArrayList<Data> data){		
		for(int i=0;i<data.size();i++){
			insert(data.get(i));
		}
	
	}
	
	public int size(){
		return size(root);
	}	
	
	private int size(Node root2) {
		if(root2==null)
			return 0;
		else{
			return (size(root2.getLeft())+1+size(root2.getRight()));
		}
	}

	public int maxDepth(){		
		return depth(root);
	}
	
	private int depth(Node node){		
		if(node == null)
			return 0;
		else{
			
			int ldepth = depth(node.getLeft());
			int rdepth = depth(node.getRight());			
			if(ldepth > rdepth)
				return (ldepth + 1);
			else
				return (rdepth+1);
		}		
	}
	
	public int minValue(){		
		return minval(root);
	}
	
	private int minval(Node node){		
		if(node == null)
			return 0;		
		while(node.getLeft()!=null){
			node = node.getLeft();
		}		
		return node.getValue().getWeight();		
	}
	
	public void printpreOrder(){
		printpre(root);
	}
	
	private void printpre(Node node) {		
		if(node == null)
			return;
		else{		
			System.out.print(node.getValue().getWeight()+"  ");
			printpre(node.getLeft());
			printpre(node.getRight());						
		}		
	}
	
	public void printTree(){		
		printin(root);
		System.out.println();
	}
	
	private void printin(Node node) {		
		if(node == null)
			return;
		else{			
			printin(node.getLeft());
			System.out.print(node.getValue().getWeight()+"  ");
			printin(node.getRight());			
		}		
	}
	
	public void printpostOrder(){
		printpost(root);
	}
	
	private void printpost(Node node) {		
		if(node == null)
			return;
		else{			
			printin(node.getLeft());
			printin(node.getRight());	
			System.out.print(node.getValue().getWeight()+"  ");
					
		}		
	}
	
	public boolean haspathsum(int sum){
		return hassum(root,sum);
	}
	
	private boolean hassum(Node node,int sum){
		
		if(node==null){
			if(sum==0)
				return true;
			else
				return false;
		}
		
		int diff = sum - node.getValue().getWeight();
		boolean leftok = hassum(node.getLeft(),diff);
		boolean rightok = hassum(node.getRight(),diff);
		
		 return (leftok == true || rightok == true);
		
	}
	
	public void printPaths(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		printpath(root,a,0);
		
	}
	
	private void printpath(Node node, ArrayList<Integer> a, int length) {		
		if(node == null)
			return;		
		
		a.add(length, node.getValue().getWeight());
		length++;
	
		if(node.getLeft()==null && node.getRight()==null)
			printarr(a,length);
		else{
			printpath(node.getLeft(),a,length);
			printpath(node.getRight(),a,length);
			
		}		
	}
	
	private void printarr(ArrayList<Integer> a, int length){
		System.out.println(" PATH :");
		for(int i=0;i<length;i++)
			System.out.println(a.get(i)+ " ");
		System.out.println();
		
	}

	public void mirror(){		
		mir(root);
	}
	
	private void mir(Node node) {
		if(node==null)
			return;
		
		if(node.getLeft()==null && node.getRight()==null)
			return;

		mir(node.getLeft());
		mir(node.getRight());
		
		Node temp1 = node.getLeft();		
		node.setLeft(node.getRight());
		node.setRight(temp1);
	}

	public boolean isBst1(){
		return isBst(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public boolean isBst(Node node, int Max, int min){
		if(node==null)
			return true;
		boolean leftok = isBst(node.getLeft(),node.getValue().getWeight(), min);
		if(leftok==false)
			return false;
		boolean rightok = isBst(node.getRight(),Max, node.getValue().getWeight());
		return rightok;	
	}

	public Node nthinordernode(int n){
		 nthorder(root,n);
		 return finalnode;
	}
	
	Node finalnode = null;
	int found = 0;
	private void nthorder(Node node,int n){
		if(node == null || n < 0 || found >= n)
			return;
		
		nthorder(node.getLeft(),n);		
		found = found + 1;
		if(found == n){
			finalnode = node;
			return;
		}
		nthorder(node.getRight(),n);		
		return;		
	}
	
	public ArrayList<Node> levelOrdertraversal(){
		
		ArrayList<Node> list = new ArrayList<Node>();
		
		if(root==null)
			return list;
		
		list.add(root);
		int size = size();
		for(int i=0; i<size;i++){
			
			Node node = list.get(i);
			
			if(node.getLeft()==null){}
			else
				list.add(node.getLeft());
			
			if(node.getRight()==null){}
			else
				list.add(node.getRight());
			
		}
		
		return list;
		
	}
	
    public ArrayList<Node> levelOrdertraversal2(){		
		ArrayList<Node> list = new ArrayList<Node>();		
		if(root==null)
			return list;		
		list.add(root);		
		int nodes = 1;
		int index = 0;
		while(index<nodes){			
			Node node = list.get(index);			
			if(node.getLeft()==null){}
			else{
				list.add(node.getLeft());
				nodes++;
			}			
			if(node.getRight()==null){}
			else{
				list.add(node.getRight());
				nodes++;
			}			
			index++;			
		}		
		return list;		
	}
	
	public Node closest_ancestor(Node root, Node a, Node b){
		
		Node l = null,r=null;
		if(root==null)
			return null;
		
		if(root.getLeft()!=null)
			if(root.getLeft().getValue().getWeight() == a.getValue().getWeight() || root.getLeft().getValue().getWeight() == b.getValue().getWeight())
				return root;
		
		if(root.getRight()!=null)
			if(root.getRight().getValue().getWeight() == a.getValue().getWeight()|| root.getRight().getValue().getWeight()==b.getValue().getWeight())
				return root;
	
				l = closest_ancestor(root.getLeft(), a, b);			
				r = closest_ancestor(root.getRight(), a, b);
			
			if(l!=null && r!=null)
				return root;// both on either side of the tree
			else{
				if(l==null)
					return r;
				else
					return l;				
			}			
	}
   
	public void doubleTree(){
    	doubletree(root);
	}

	private void doubletree(Node node) {
		if(node==null)
			return;
		
		doubletree(node.getLeft());
		doubletree(node.getRight());
		
		Node temp = node.getLeft();		
		Data d = new Data(new Integer(node.getValue().getWeight()).toString(), node.getValue().getWeight());
		Node n = new Node(d, null,null);
		node.left = n;		
		node.getLeft().setLeft(temp);
	}

	public BinaryTree copyTree(){	
		
		BinaryTree newtree = new BinaryTree();
		newtree.root = copytree(root);
		return newtree;
	}
	
	private Node copytree(Node node) {
		if(node==null)
			return null;
		
		Data d = new Data(new Integer(node.getValue().getWeight()).toString(), node.getValue().getWeight());
		Node n = new Node(d, null,null);
		
		n.left = copytree(node.getLeft());
		n.right = copytree(node.getRight());
		
		return n;		
	}

	public boolean sameTree(Node one, Node other){
		
		if(one==null && other ==null)
			return true;
		else if(one!=null &&other !=null){
			boolean val = false, leftok = false, rightok = false;
			if(one.getValue().getWeight() == other.getValue().getWeight())
				  val = true;
			leftok = sameTree(one.getLeft(),other.getLeft());
			rightok = sameTree(one.getRight(),other.getRight());
			return (val&&leftok&&rightok);
		}
		else 
			return false;
	}
	
	int leafcount = 0;
	public int countLeaf(){
		leafcount = 0;		
		countleaf(root);
		return leafcount;
	}	
	
	private void countleaf(Node node) {
		if(node == null)
			return;
		else{			
			countleaf(node.getLeft());
			if(node.getLeft()==null && node.getRight()==null)
				leafcount++;
			countleaf(node.getRight());
		}
	}

	public int countTrees(int numkeys){// TODO 2^n -n trees possible -- NOT SURE
		if(numkeys<=1)
			return 1;
		else{
			
			int sum = 0;
			int left,right, root;
			
			for(root = 1; root<numkeys;root++){				
				left = countTrees(root-1);
				right = countTrees(numkeys-root);				
				sum += left*right;				
			}
			return sum;			
		}
	}	

	public boolean deleteNodefromBST(int value){		
		if(root == null)
			return false;
		else if(root.getValue().getWeight()==value){			
			Data dummydata = new Data("dummy", value);
			Node dummy = new Node(dummydata, root, null);			
			boolean result = root.remove(value, dummy);			
			root = dummy.getLeft();
			return result;
		}else{
			return root.remove(value, null);
		}
	}
	
	public boolean deleteNodefromBSTLeft(int value){		
		if(root == null)
			return false;
		else if(root.getValue().getWeight()==value){			
			Data dummydata = new Data("dummy", value);
			Node dummy = new Node(dummydata, root, null);			
			boolean result = root.removeLeft(value, dummy);			
			root = dummy.getLeft();
			return result;
		}else{
			return root.remove(value, null);
		}
	}
	
	public int returnClosest(int key){
		
		 ArrayList<Node> stack = new ArrayList<Node>();
		 stack.add(root);
		 
		 Node minnode = root;
		 int mindiff = Integer.MAX_VALUE;
		 for(int i=0;i<stack.size();i++){
			 Node current = stack.get(i);
			 
			 if(current.getValue().getWeight()==key){
				 minnode = current;
				 break;
			 }
			 
			 if(Math.abs(current.getValue().getWeight()-key)<mindiff){
				 minnode = current;
				 mindiff = Math.abs(current.getValue().getWeight()-key);
			 }
			 
			 if(current.getLeft()!=null){
				 if(key<current.getValue().getWeight())
					 stack.add(current.getLeft());
			 }
			 if(current.getRight()!=null){
				if(key>current.getValue().getWeight()) 
					stack.add(current.getRight());
			 }
		}
		return minnode.getValue().getWeight();
	}
	

	//tree is height-balanced if the heights of the left and right subtree's of each node are within 1
	/*
	 * (height balanced) heights of left and right subtrees are within 1
(BST) values in left subtree are smaller than root value, which is smaller than the values in the right subtree.
	 */
	public boolean isbalanced(){
		if (root ==null)
			return true;
		return root.isbalanced();
	}
	
	
	public boolean bfs(int look){
		return bfssearch(root,look);		
	}

	private boolean bfssearch(Node node,int look) {		
		
		ArrayList<Node> node_list = new ArrayList<Node>();		
		if(node==null)
			return false;		
		node_list.add(node);		
		int nodes = 1;
		int index = 0;
		while(index<nodes){			
			Node node1 = node_list.get(index);
			
			System.out.println("Visited" + node1.getValue().getWeight());
			if (node1.getValue().getWeight()==look){
				return true;
			}			
			if(node1.getLeft()==null){}
			else{
				node_list.add(node1.getLeft());				
				nodes++;
			}			
			if(node1.getRight()==null){}
			else{
				node_list.add(node1.getRight());
				nodes++;
			}			
			index++;			
		}				
		return false;		
	}

	public boolean dfs(int look){
		return dfssearch(root,look);
		
	}
	
	private boolean dfssearch(Node node, int look) {
		if(node==null)
			return false;
		
		boolean foundleft = dfssearch(node.getLeft(),look);
		System.out.println("Visited" + node.getValue().getWeight());
		if (node.getValue().getWeight()==look){
			return true;
		}
		if(foundleft== true)
			return true;
		
		boolean foundright = dfssearch(node.getRight(),look);
		return foundright;
	}
	
	public void preorder( ) {
	    if( root == null ) return;
	 
	    Stack<Node> stack = new Stack<Node>( );
	    stack.push( root );
	 
	    while( ! stack.isEmpty( ) ) {
	        Node current = stack.pop( );
	       // System.out.println("popped------------->" + current.getValue().getWeight());
	        if( current.right != null ){
	        	stack.push( current.right );
	        	 // System.out.println("<---------Pushed" +  current.right.getValue().getWeight());
	        }
	        if( current.left != null ){
	        	stack.push( current.left );
	        	  //System.out.println("<---------Pushed" + current.left.getValue().getWeight());
	        }
	        System.out.print( current.getValue().getWeight() + " " );
	    }
	}
	 

	public void inorder( ) {
	    Node node = root;
	    Stack<Node> stack = new Stack<Node>( );
	    while( ! stack.isEmpty( ) || node != null ) {
	        if( node != null ) {
	            stack.push( node );
	            node = node.left;
	        } else {
	            node = stack.pop( );
	            System.out.print( node.getValue().getWeight() + " " );
	            node = node.right;
	        }
	    }
	}
	 

	public void postorder( ) {
	    if( root == null ) return;
	 
	    Stack<Node> stack = new Stack<Node>( );
	    Node current = root;
	 
	    while( true ) {
	 
	        if( current != null ) {
	            if( current.right != null ){
	            	stack.push( current.right );
	            	//System.out.println("<---------Pushed" +  current.right.getValue().getWeight());
	            }
	            stack.push( current );
	            //System.out.println("<---------Pushed" +  current.getValue().getWeight());
	            current = current.left;
	            //System.out.println("<-- swapped current with left --->");
	            continue;
	        }
	 
	        if( stack.isEmpty( ) ) return;
	        current = stack.pop( );
	        System.out.println("popped------------->" + current.getValue().getWeight());
	 
	        if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
	            Node popped = stack.pop( );
	            //System.out.println("popped------------->" + popped.getValue().getWeight());
	            stack.push( current );
	            current = current.right;
	           // System.out.println("<-- swapped current with right ---> " +  current.getValue().getWeight());
	        } else {
	            System.out.print("*****"+ current.getValue().getWeight() + " " );
	            current = null;
	        }
	    }
	}

		//expression tree and evaluate 
		//tree to array
		// from inorder/ post order to a tree
		//heap sort
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();		
		ArrayList<Data> data_arr = new ArrayList<Data>();
		/*for(Integer i=0; i<5;i++){
			
			Data d = new Data(i.toString(), i);
			data_arr.add(d);
		}
		for(Integer i=-1; i>-5;i--){
			
			Data d = new Data(i.toString(), i);
			data_arr.add(d);
		}*/
		
		/*Data d2 = new Data("2", 2);
		data_arr.add(d2);
		Data d1 = new Data("3", 3);
		data_arr.add(d1);
		Data d = new Data("1", 1);
		data_arr.add(d);		
		*/
		
		Data d5 = new Data("5", 5);
		data_arr.add(d5);
		Data d1 = new Data("3", 3);
		data_arr.add(d1);
		Data d20 = new Data("-20", -20);
		data_arr.add(d20);		
		
		Data d100 = new Data("100", 100);
		data_arr.add(d100);
		Data d23 = new Data("23", 23);
		data_arr.add(d23);
		Data d67 = new Data("67", 67);
		data_arr.add(d67);
		Data d13 = new Data("13", 13);
		data_arr.add(d13);
		

		tree.build(data_arr);

		int s = tree.size();
		Node root = tree.getRoot();
		
		System.out.println("Max Depth"+ tree.maxDepth());
		System.out.println("LEAST VALUE" + tree.minValue());
		System.out.println("IS IT BST ?"+tree.isBst1());
		System.out.println("HAS SUM of 36"  + tree.haspathsum(36));		
		System.out.println("Can find 3"  + tree.lookup(3));
		
		System.out.println("____________________________PRINTTREE (Inorder)");
		tree.printTree();
		System.out.println("____________________________PRETTY TREE");
		TreePrinter.printNode(root);
		
		System.out.println("Closest to 10  :" + tree.returnClosest(10));
		System.out.println("Closest to 4  :" + tree.returnClosest(4));
		System.out.println("Closest to 2  :" + tree.returnClosest(2));
		System.out.println("Closest to -100  :" + tree.returnClosest(-100));
		System.out.println("Closest to 14  :" + tree.returnClosest(14));
		System.out.println("Closest to 8  :" + tree.returnClosest(8));
		System.out.println("Closest to 20  :" + tree.returnClosest(20));
		System.out.println("Closest to 101  :" + tree.returnClosest(101));
		System.out.println("Closest to 25  :" + tree.returnClosest(25));
		System.out.println("Closest to 90  :" + tree.returnClosest(90));
		System.out.println("Closest to 60  :" + tree.returnClosest(60));
		System.out.println("Closest to 70  :" + tree.returnClosest(70));
		
		System.out.println("____________________________POSSIBLE PATHS");
		tree.printPaths();		
		System.out.println();
		System.out.println("____________________________PREORDER");
		tree.printpre(root);
		System.out.println();
		System.out.println("____________________________INORDER");
		tree.printin(root);
		System.out.println();
		System.out.println("____________________________POSTORDER");
		tree.printpostOrder();
		System.out.println();
		System.out.println("____________________________ LEVEL ORDER");
		ArrayList<Node> levelorder = tree.levelOrdertraversal2();
		for(Node n:levelorder)
			System.out.println(n.getValue().getWeight());
		System.out.println();	
		System.out.println("_________________________________PREORDER in ITERATIVe");
		tree.preorder();
		System.out.println();
		System.out.println("_________________________________INORDER in ITERATIVe");
		tree.inorder();
		System.out.println();
		System.out.println("_________________________________POSTORDER in ITERATIVe");
		tree.postorder();
		System.out.println();
		System.out.println("____________________________6 th inorder node");
		Node node = tree.nthinordernode(6);
		if(node == null)
			System.out.println("NO NODE FOUNd");
		else
			System.out.println("NOde value"+ node.getValue().getWeight());
		
		
		
		Node n13 = new Node(d13, null, null);
		Node n20 = new Node(d20, null, null);		
		Node n67 = new Node(d67, null, null);
		Node n23 = new Node(d23, null, null);
		Node n100 = new Node(d100, null, null);
		Node n1 = new Node(d1, null, null);
		
		System.out.println("____________________________CLOSEST ANCESTORS");
		
		Node r1 = tree.closest_ancestor(root, n13, n67);
		System.out.println(" 13 and 67 - "+r1.getValue().getWeight());
		
		Node r2 = tree.closest_ancestor(root, n20, n13);
		System.out.println(" 20 and 13 - "+r2.getValue().getWeight());
		
		Node r3 = tree.closest_ancestor(root, n23, n67);
		System.out.println(" 23 and 67 - "+r3.getValue().getWeight());
		
		Node r4 = tree.closest_ancestor(root, n1, n100);
		System.out.println(" 1 and 100 - "+r4.getValue().getWeight());
		
		Node r5 = tree.closest_ancestor(root, n20, n13);
		System.out.println(" 20 and 13 - "+r5.getValue().getWeight());
		
		System.out.println("_________________________________Copied TREE");
		BinaryTree copied = tree.copyTree();
		TreePrinter.printNode(copied.root);
		
		
		System.out.println("REMOVING FROM RIGHT SUB TREE________________________________");
		System.out.println("After deleting :5");
		copied.deleteNodefromBST(5);
		TreePrinter.printNode(copied.root);
		
		
		System.out.println("After deleting :3");
		copied.deleteNodefromBST(3);
		TreePrinter.printNode(copied.root);
		
		
		System.out.println("After deleting :-20");
		copied.deleteNodefromBST(-20);
		TreePrinter.printNode(copied.root);
		
		BinaryTree copiedleft = tree.copyTree();

		
		
		System.out.println("REMOVING FROM LEFT SUB TREE___________________________________");
		
		TreePrinter.printNode(copiedleft.root);
		System.out.println("IS It Balanced ????" + copiedleft.isbalanced());
		System.out.println("After deleting :5");
		copiedleft.deleteNodefromBSTLeft(5);
		TreePrinter.printNode(copiedleft.root);
		System.out.println("IS It Balanced ????" + copiedleft.isbalanced());
		
		System.out.println("After deleting :3");
		copiedleft.deleteNodefromBSTLeft(3);
		TreePrinter.printNode(copiedleft.root);
		System.out.println("IS It Balanced ????" + copiedleft.isbalanced());
		
		
		System.out.println("After deleting :-20");
		copiedleft.deleteNodefromBSTLeft(-20);
		TreePrinter.printNode(copiedleft.root);
		System.out.println("IS It Balanced ????" + copiedleft.isbalanced());
		
		System.out.println("After deleting :100");
		copiedleft.deleteNodefromBSTLeft(100);
		TreePrinter.printNode(copiedleft.root);
		System.out.println("IS It Balanced ????" + copiedleft.isbalanced());
		
		
		
		
		System.out.println("_________________________________SAME TREE OR NOT - SAME");
		System.out.println(tree.sameTree(tree.getRoot(), copied.getRoot()));
		
		System.out.println("_________________________________LEAF COUNT ");
		System.out.println(tree.countLeaf());
		
		System.out.println("_________________________________TREE POSSIBILITY COUNT "  + tree.size());
		System.out.println(tree.countTrees(tree.size()));
		
		System.out.println("_________________________________BREADTH FIRST SEARCH");
		System.out.println(tree.bfs(-20));
		
		System.out.println("_________________________________DEPTH FIRST SEARCH");
		System.out.println(tree.dfs(13));
		
		System.out.println("_________________________________DOUBLE TREE");
		tree.doubleTree();
		TreePrinter.printNode(root);		
		
		System.out.println("_________________________________BREADTH FIRST SEARCH");
		System.out.println(tree.bfs(-20));
		
		System.out.println("_________________________________DEPTH FIRST SEARCH");
		System.out.println(tree.dfs(13));
		
		System.out.println("_________________________________SAME TREE OR NOT - NOT SAME");
		System.out.println(tree.sameTree(tree.getRoot(), copied.getRoot()));
		
		System.out.println("_________________________________LEAF COUNT ");
		System.out.println(tree.countLeaf());
		
		System.out.println("_________________________________TREE POSSIBILITY COUNT "+ tree.size());
		System.out.println(tree.countTrees(tree.size()));
		
		System.out.println();
		System.out.println();

	}

}
