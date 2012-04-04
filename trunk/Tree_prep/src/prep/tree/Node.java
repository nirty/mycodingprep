package prep.tree;

public class Node implements Comparable<Node>{
	
	Data value;
	Node left;
	Node right;
	private boolean visited;
	
	
	Node(Data val, Node left1,Node right1){
		setValue(val);
		left = left1;
		right = right1;		
	}	

	public Data getValue() {
		return value;
	}

	public void setValue(Data value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public int compareTo(Node o) {	
		if(this.getValue().getWeight()< o.getValue().getWeight())
			return -1;
		else if (this.getValue().getWeight()> o.getValue().getWeight())
			return 1;
		else
			return 0;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	

}
