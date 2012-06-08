package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthLargest {

	public static int kthlargest(int arr[],int k){
		
		if(k < 1 || k > arr.length){			
			return -1;
		}		
		return kthlargest_partioning(arr, 0, arr.length -1, k - arr.length + 1);		
	}
	
	public static int kthlargest_partioning(int arr[], int start, int end, int k){
	int pivot = start;
	int left = start;	
	int right = end;
	
	System.out.println("Start :" + start + " End: " + end + "Pivot :" + pivot + " K value: " + k);
	
	
	while(left<= right){		
		while(left<= right && arr[left]<= arr[pivot])
			++left;
		while(left<=right && arr[right]>=arr[pivot])
			--right;
		
		
		if(left<right)
			swap(arr,left,right);
	}
	
	
	
	swap(arr,pivot,right);
	
	System.out.println("pivot set for index :"+ right);
	
	if(k==right + 1)
		return arr[right];
	else if (k>right+1)
		return kthlargest_partioning(arr,right+1,end,k);
	else
		return kthlargest_partioning(arr,start,right-1,k);	
	}
	
	
	public static void quickSort(int arr[]){
		
		quickSort(arr,0, arr.length-1);
		System.out.println("___________________QUICK SORT___________________");
		print(arr);
		
	}
	
	public static void print(int arr[]){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();		
	}
	
	
	static void quickSort(int arr[], int low, int high)
    {
       if (low >= high) return;
       int p = partition(arr, low, high);
       quickSort(arr, low, p);
       quickSort(arr, p + 1, high);
    }
 
    static int partition(int a[], int low, int high)
    {
       // First element
       int pivot = a[low];
 
      // Middle element
       //int middle = (low + high) / 2;
       //int pivot = a[middle];

       int i = low - 1;
       int j = high + 1;
       while (i < j)
       {
          i++; 
          j--;
          while (a[i] < pivot) 
        	  i++;
           
          while (a[j] > pivot) 
        	  j--;
          
          
          if (i < j) 
        	  swap(a, i, j);
      }
       return j;
    }
 
    /**
       Swaps two entries of the array.
       @param i the first position to swap
       @param j the second position to swap
    */
    static void swap(int a[], int i, int j)
    {
       int temp = a[i];
       a[i] = a[j];
       a[j] = temp;
    }
 
	public static void main(String[] args) {
		
		
		int[] test_array1 = {5,2,9,1,6};
		int arr[] =  {1, 12, 5, 26, 7, 14, 3, 7, 2};
		
		int testarr[] = {9,28,1,12,5,26,7,14,3,7,2};
		//quickSort(test_array1);
		//quickSort(arr);
		//quickSort(testarr);
		
		
		print(testarr);
		int pos = 11;
		System.out.println("K th Largest number" + pos);
		System.out.println(kthlargest(testarr, pos));
		print(testarr);
		
		//int[] test_array2 = {1,7,59, 73,22, 65,90,2,4,10,50};		
		//System.out.println("Largest element - Median of Medians");
		//System.out.println(kthlargest_medianofmedians(test_array2,0,test_array2.length-1, 1));
		
	}

}
