package sorting;
import java.util.*;
public class BinarySearchRotated {
	    static int findMinimum(Integer[] arr) {
	        int low = 0;
	        int high = arr.length - 1;
	        while (arr[low] > arr[high]) {
	            int mid = (low + high) >>> 1;
	            if (arr[mid] > arr[high]) {
	                low = mid + 1;
	            } else {
	                high = mid;
	            }
	        }
	        return low;
	    }
	    
	    static int findElement(Integer[] arr, int key){
	    	
	    	//int pivot = findPivot(arr , 0 , arr.length-1);
	    	int pivot = findMinimum(arr);
	    	   if(arr[pivot] == key)
	    	     return pivot;
	    	   if(arr[0] <= key)
	    	     return binarySearch(arr, 0, pivot-1, key);
	    	   else
	    	     return binarySearch(arr, pivot+1, arr.length -1 , key);
	    }
	    
	   static int findPivot(Integer arr[], int low, int high)
	    {
	       int mid = (low + high)/2;   /*low + (high - low)/2;*/
	       if(arr[mid] > arr[mid + 1])
	         return mid;
	       if(arr[low] > arr[mid])
	         return findPivot(arr, low, mid-1);
	       else
	         return findPivot(arr, mid + 1, high);
	    }
	    
	    static int binarySearch(Integer arr[], int low, int high, int no)
	    {
	      if(high >= low)
	      {
	        int mid = (low + high)/2;  /*low + (high - low)/2;*/
	     
	        if(no == arr[mid])
	          return mid;
	        if(no > arr[mid])
	          return binarySearch(arr, (mid + 1), high, no);
	        else
	          return binarySearch(arr, low, (mid -1), no);
	      }
	      /*Return -1 if element is not found*/
	      return -1;
	    }
	    
	    
	    static int circularBinSearch (Integer[] A, int key, int low, int high )
	    {
	        if (low > high)
	        {
	            return -1; // not found
	        }

	        int mid = (low + high) / 2;

	        if (A[mid] == key)
	        {
	            return mid;
	        }
	        else if (key < A[mid])
	        {
	            return ((A[low] <= A[mid]) && (A[low] > key)) ?
	                   circularBinSearch(A, key, mid + 1, high) :
	                   circularBinSearch(A, key, low, mid - 1);
	        }
	        else // key > A[mid]
	        {
	            return ((A[mid] <= A[high]) && (key > A[high])) ?
	                   circularBinSearch(A,key, low, mid - 1) :
	                   circularBinSearch(A, key, mid + 1, high);
	        }
	    }
	    
	    static void swap(Integer a[], int i, int j)
	    {
	       int temp = a[i];
	       a[i] = a[j];
	       a[j] = temp;
	    }
	    
	    static void reverse(Integer a[],int start,int end){	    	
	    	while(start<=end){	    		
	    		swap(a, start, end);	    		
	    		start++;
	    		end--;
	    	}	    	
	    }
	    
	    static void rotate(Integer a[],int positions){
	    	
	    	reverse(a,0,positions-1);
	    	reverse(a,positions,a.length-1);
	    	reverse(a,0,a.length-1);
	    }
	    public static void main(String[] args) {
	    	
	    	
	        Integer[] arr = {1, 2, 3, 4, 5, 6, 7 };
	        // must be in sorted order, allowing rotation, and contain no duplicates

	        rotate(arr, 3);
	        
	        System.out.println("After rotating 3 positions : "+ Arrays.toString(arr));
	        
	        
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(Arrays.toString(arr));
	            int minIndex = findMinimum(arr);
	            System.out.println(" Min is " + arr[minIndex] + " at " + minIndex);
	            int keyIndex = findElement(arr, 6);
            	System.out.println(" Value found is 6 at " + keyIndex); //does not work when it is already sorted position at 0
            	
            	//Working  :-)
            	int keycircularIndex = circularBinSearch(arr, 6,0,arr.length-1);
            	System.out.println(" Value found is 6 at " + keycircularIndex); //does not work when it is already sorted position at 0
            	
            	Collections.rotate(Arrays.asList(arr), 1);
	        }
	       
	    }
}
