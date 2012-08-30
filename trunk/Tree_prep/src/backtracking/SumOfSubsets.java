package backtracking;

import java.util.Arrays;
//Need to Work on the Bound condition
public class SumOfSubsets {

	
	public int arr[];
	public boolean b_arr[];
	
	public void SumOfSubsets(int[] givenarr, int sum){
		Arrays.sort(givenarr);
		arr = givenarr;
		b_arr = new boolean[arr.length];
		for(int i=0;i<b_arr.length;i++){
			b_arr[i]=false;
		}		
		
		findSubsets(0,sum,0,sum);
	}
	
	public void findSubsets(int pos, int K, int currsum, int bound) {

		if (isPromimsing(pos, currsum, K, bound)) {

			if (currsum == K) {
				System.out.println("Found Matched Subsets");

				for (int i = 0; i <= b_arr.length - 1; i++) {
					if (b_arr[i] == true) {
						System.out.print(arr[i] + "  ");
					}
				}
				System.out.println();

			} else {

				if (pos <= arr.length - 1) {
					b_arr[pos] = true;
					findSubsets(pos + 1, K, currsum + arr[pos], bound- arr[pos]);

					b_arr[pos] = false;
					findSubsets(pos + 1, K, currsum, bound - arr[pos]);
				}
			}
		}

	}
	
	private boolean isPromimsing(int pos, int currsum, int K, int bound) {	
		
		if(currsum==K){
			return true;
		}
		
		if(currsum>K){
			return false;
		}
		
//		if(currsum + bound <K )
//			return false;
		
		return true;
	}


/*
 * 
 * w = an array of positive integers sorted in non-decreasing order.
W = the target sum value
include = an array or arraylist of the solutions who's weight adds up to W. After the print statement, this array can be deleted so that it can store the next solution.
weight = weight of elements in the include array.
total = weight of the remaining elements not in the include array.

public static void sum_of_subsets(index i, int weight, int total)
{
     if(promising(i))
     {
          if(weight == W)
          {
               System.out.print(include[1] through include[i]);
          }
          else
          {
               include[i + 1] = "yes";     //Include w[i + 1]
               sum_of)subsets(i + 1, weight + w[i + 1], total - w[i + 1]);
               include[i + 1] = "no";      //Do not include w[i + 1]
               sum_of_subsets(i + 1, weight, total - w[i + 1]);
          }
     }
}

public static boolean promising(index i);
{
     return (weight + total >= W) && (weight == W || weight + w[i + 1] <= W);
}
 */

	public static void main(String args[]){
		
		int arr[] = {5,6,10,11,16};
		SumOfSubsets s = new SumOfSubsets();
		s.SumOfSubsets(arr, 21);
		
	}
}
