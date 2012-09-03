package backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KnapSackBestFirst {

	public static void main(String[] args) {		
		int p[] = {50, 10, 30, 40};
		int w[] = {10, 5 ,5 ,2};
		KnapSackBestFirst kp = new KnapSackBestFirst();		
		kp.knapsack(p ,w ,16);		
	}

	int[] weights;
	int[] profits;
	int[] profitsbyweights;
	boolean[] include;
	int maxweight;
	int bestprofit =0;
	ArrayList<Node> bestset = new ArrayList<Node>();
	Node lastNode;
	public void sortbasedofpbyw(int[] p,int[] w,int[] pw){		
		for(int i=0;i<p.length;i++){			
			pw[i] = p[i] / w[i];			
		}	
		
		for(int i=0 ;i<p.length;i++){
			int mini = i;
			for(int j=i+1;j<p.length;j++)
			{				
				if( pw[j]> pw[mini]){
					mini=j;
				}
			}			
			if(mini!=i){				
				KnapSack.swap(pw, i,mini, "sorting");
				KnapSack.swap(p, i,mini, "sorting");
				KnapSack.swap(w, i,mini, "sorting");
			}			
		}		
	}
	
	
	private void knapsack(int[] p, int[] w, int maxw) {
		
		int[] pw = new int[p.length];
		//sortbasedofpbyw(p ,w,pw);
		profitsbyweights = pw;
		weights = w;
		profits = p;
		maxweight = maxw;
		include = new boolean[weights.length];
		
		for(int i=0;i<include.length;i++)
			include[i] = false;
		bestFirst();
		printbestset(lastNode);
		System.out.println(bestprofit);
	}
	
	private void bestFirst() {
		
		Comparator<Node> profitcomparator = new NodeProfitComparator();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(10, profitcomparator);
		
		Node fst = new Node();
		fst.level = 0;
		fst.profitcounted = profits[0];
		fst.weightcounted = weights[0];	
		fst.bound = bound(fst);
		fst.parent = null;
		fst.included = true;
		queue.add(fst);
		
		while(!queue.isEmpty()){			
			
			Node v = queue.remove();
			
			if(v.bound > bestprofit){
				
				
				Node u = new Node();
				u.level = v.level +1;
				u.profitcounted = v.profitcounted + profits[u.level];
				u.weightcounted = v.weightcounted + weights[u.level];
				u.parent = v;
				u.included = true;
				if(u.weightcounted <= maxweight && u.profitcounted > bestprofit){
					bestprofit = u.profitcounted;
					lastNode = u;					
				}
					
				u.bound = bound(u);
				if(u.bound > bestprofit)					
					queue.add(u);
				
				u.profitcounted = v.profitcounted;
				u.weightcounted = v.weightcounted;
				u.bound = bound(u);
				if(u.bound > bestprofit){	
					u.included = false;
					queue.add(u);
				}
					
			}
			
					
		}
		
		
	}

	private int bound(Node u) {		
	
		if(u.weightcounted > maxweight) //weight condition is not satisfied
			return 0;	
		
		//greedy calculation to find the best profit upper bound. 
		// even if u add all the following nodes. this does not yield a better result.
		//so stop going down.
		int j = u.level + 1;
		int boundprofit =u.profitcounted;
		int boundweight = u.weightcounted;
		
		while(j< profits.length && boundweight + weights[j] <= maxweight ){			
			boundprofit = boundprofit + profits[j];
			boundweight = boundweight + weights[j];
			j++;
		}
		
		if(j<weights.length)
			boundprofit = boundprofit + ( maxweight - boundweight ) * profitsbyweights[j];
		
		return boundprofit;
	}


	private void printbestset(Node bestnode) {		
		
		
		while(bestnode!=null){
			
			if(bestnode.included == true)
				System.out.println( " Profit: " + profits[bestnode.level] + " weight: " + weights[bestnode.level]);	
			
			bestnode = bestnode.parent;
		}
//		for(int i=0;i<bestset.length;i++){	
//			if(bestset[i]!=null)
//				System.out.println( " Profit: " + profits[bestnode.level] + " weight: " + weights[bestnode.level]);					
//		}
		//System.out.println( " total profit : " + profittotal + " : Best PRofit : " + bestprofit );
	}
	
	public class Node{
		public int level;
		public int profitcounted;
		public int weightcounted;
		public float bound;
		public Node parent;
		public boolean included;
	}
	
	public class NodeProfitComparator implements Comparator<Node>
	{
	    @Override
	    public int compare(Node x, Node y)
	    {
	        if (x.bound < y.bound)
	        {
	            return -1;
	        }
	        if (x.bound > y.bound)
	        {
	            return 1;
	        }
	        return 0;
	    }
	}
}
