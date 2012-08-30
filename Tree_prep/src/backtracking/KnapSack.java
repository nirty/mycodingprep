package backtracking;

import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

public class KnapSack {

	public static void main(String[] args) {
		
		int p[] = {50, 10, 30, 40};
		int w[] = {10, 5 ,5 ,2};
		KnapSack kp = new KnapSack();		
		kp.knapsack_backtracking(p ,w ,16);		
	}

	
	int[] weights;
	int[] profits;
	int[] profitsbyweights;
	boolean[] include;
	int maxweight;
	int bestprofit =0;
	ArrayList<ArrayList<Boolean>> bestset = new ArrayList<ArrayList<Boolean>>();
	boolean[] bestinclude;
	
	
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
	
	static void swap(int a[], int i, int j, String printhelper) {
		//System.out.println("Swapping :" + i + " & " + j  +" that is " + a[i] + " & " + a[j]  + " : " + printhelper);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void knapsack_backtracking(int[] p,int[] w,int maxw){
		
		int[] pw = new int[p.length];
		sortbasedofpbyw(p ,w,pw);
		profitsbyweights = pw;
		weights = w;
		profits = p;
		maxweight = maxw;
		include = new boolean[weights.length];
		
		for(int i=0;i<include.length;i++)
			include[i] = false;
		recurse_backtracking( -1, 0, 0);
		printbestinclude(bestinclude);
	}


	private void printbestinclude(boolean[] bestinclude2) {
		
		int profittotal =0;
		for(int i=0;i<bestinclude2.length;i++){
			
			if(bestinclude2[i]==true){
				profittotal  = profittotal + profits[i];
				System.out.println( " Profit: " + profits[i] + " weight: " + weights[i]);
			}
				
		}
		System.out.println( " total profit : " + profittotal + " : Best PRofit : " + bestprofit );
	}

	private void recurse_backtracking(int currposition, int currweight, int currprofit) {
		
		if(currweight<=maxweight && currprofit>bestprofit ){				
			bestprofit = currprofit;
			bestinclude = new boolean[include.length];
			System.arraycopy(include, 0, bestinclude, 0, include.length);
			printbestinclude(bestinclude);
			System.out.println();
		}
		
		if(ispromising(currposition,currweight,currprofit)){			
				include[currposition + 1] = true;
				recurse_backtracking(currposition + 1, currweight + weights[currposition + 1], currprofit+ profits[currposition +1 ]);			
				
				include[currposition + 1] = false;
				recurse_backtracking(currposition + 1, currweight, currprofit);					
		}		
	}


	private boolean ispromising(int currposition, int currweight, int currprofit) {
		
		if(currposition == -1) // start node. just go ahead
			return true;
		if(currposition +1 == weights.length) // this is the leaf node. last node
			return false;
		if(currweight + weights[currposition+1] > maxweight) //weight condition is not satisfied
			return false;	
		
		//greedy calculation to find the best profit upper bound. 
		// even if u add all the following nodes. this does not yield a better result.
		//so stop going down.
		int j = currposition + 1;
		int boundprofit =currprofit;
		int boundweight = currweight;
		while(j< profits.length && boundweight + weights[j] <= maxweight ){			
			boundprofit = boundprofit + profits[j];
			boundweight = boundweight + weights[j];
			j++;
		}
		
		if(j<weights.length)
			boundprofit = boundprofit + ( maxweight - boundweight ) * profitsbyweights[j];

		if (boundprofit >bestprofit)
			return true;
		else
			return false;
	}
}
