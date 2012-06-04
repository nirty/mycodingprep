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

	//Remove from lowest value from Right subtree
	public boolean remove(int value, Node parent){
		 if (value < this.getValue().getWeight()) {
             if (left != null)
                   return left.remove(value, this);
             else
                   return false;
       } else if (value > this.getValue().getWeight()) {
             if (right != null)
                   return right.remove(value, this);
             else
                   return false;
       } else{
    	   
    	   if (left != null && right != null) {
               this.value.setWeight(right.minValue());
               right.remove(this.value.getWeight(), this);
    	   } else if (parent.left == this) {
               parent.left = (left != null) ? left : right;
    	   } else if (parent.right == this) {
               parent.right = (left != null) ? left : right;
    	   }
         return true;
    	   
       }
	}
	
	private int minValue() {
	      if (left == null)
	            return value.getWeight();
	      else
	            return left.minValue();
	}
	
	public boolean removeLeft(int value, Node parent){
		if (value < this.getValue().getWeight()) {
            if (left != null)
                  return left.remove(value, this);
            else
                  return false;
      } else if (value > this.getValue().getWeight()) {
            if (right != null)
                  return right.remove(value, this);
            else
                  return false;
      } else{
   	   
   	   if (left != null && right != null) {
              this.value.setWeight(left.maxValue());
              left.remove(this.value.getWeight(), this);
   	   } else if (parent.left == this) {
              parent.left = (left != null) ? left : right;
   	   } else if (parent.right == this) {
              parent.right = (left != null) ? left : right;
   	   }
        return true;
   	   
      }
	}
	
	private int maxValue() {
	      if (right == null)
	            return value.getWeight();
	      else
	            return right.minValue();
	}

	public boolean isbalanced(){// TODO
		if (this ==null)
			return true;
		
		int leftht = height(this.getLeft());
		int rightht = height(this.getRight());
		
		if(Math.abs(leftht - rightht)<=1){
			
			
			boolean leftbalanced = false;
			boolean rightbalanced = true;
			
			if(this.getLeft() == null)
				leftbalanced = true;
			else
				leftbalanced = this.getRight().isbalanced();
			
			if(this.getRight() == null)
				rightbalanced = true;
			else
				rightbalanced = this.getRight().isbalanced();
			
			if(leftbalanced == true && rightbalanced == true)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	private int height(Node node)
	{
	   /* base case tree is empty */
	   if(node == null)
	       return 0;
	 
	   /* If tree is not empty then height = 1 + max of left
	      height and right heights */
	   return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	} 
	
}
