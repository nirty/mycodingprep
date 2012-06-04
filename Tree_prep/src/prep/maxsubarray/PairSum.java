package prep.maxsubarray;

import java.util.Arrays;

public class PairSum {
	
	public static int sumOfSubset(int[] array, int sum)
	{
	        // This has a complexity of O ( n lg n )
	        Arrays.sort(array);

	        int pairCount = 0;
	        int leftIndex = 0;
	        int rightIndex = array.length - 1;

	        // The portion below has a complextiy of
	        //  O ( n ) in the worst case.
	        while (array[rightIndex] >= sum)
	        {
	            rightIndex--;    
	        }

	        while (leftIndex < rightIndex)
	        {
	            if (array[leftIndex] + array[rightIndex] == sum)
	            {
	                pairCount++;
	                leftIndex++;
	                rightIndex--;
	            }
	            else if(array[leftIndex] + array[rightIndex]  < sum)
	            {
	                leftIndex++;
	            }
	            else
	            {
	                rightIndex--;   
	            }
	        }
	        
	        return pairCount;
	}
	
	public static void closestSum(int[] arr){
		
		// Variables to keep track of current sum and minimum sum
		  int sum, min_sum = Integer.MAX_VALUE;
		  
		  int n = arr.length;
		 
		  // left and right index variables
		  int l = 0, r = n-1;
		 
		  // variable to keep track of the left and right pair for min_sum
		  int min_l = l, min_r = n-1;
		 
		  /* Array should have at least two elements*/
		  if(n < 2)
		  {
		    System.out.println("Invalid Input");
		    return;
		  }
		 
		  Arrays.sort(arr);
		 
		  while(l < r)
		  {
		    sum = arr[l] + arr[r];
		 
		    /*If abs(sum) is less then update the result items*/
		    if(Math.abs(sum) < Math.abs(min_sum))
		    {
		      min_sum = sum;
		      min_l = l;
		      min_r = r;
		    }
		    if(sum < 0)
		      l++;
		    else
		      r--;
		  }
		 
		  System.out.println(" The two elements whose sum is minimum are  :" + arr[min_l]  +" &" + arr[min_r]);
	}
	
	public static void main(String args[]){		
		int arr4[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4};	
		System.out.println("Sum of Subset" + sumOfSubset(arr4,3));
		 int arr[] = {1, 60, -10, 70, -80, 85};
		System.out.println("Closest to Zero");
		closestSum(arr);
	}

}
