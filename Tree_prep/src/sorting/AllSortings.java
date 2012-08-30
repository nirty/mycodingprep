package sorting;

import java.util.Random;

public class AllSortings {

	
	public static void main(String args[]){
		
		//int arr[] = {12,9,4,99,120,1,3,10};
		int arr[] =  {1, 12, 5, 26, 7, 14, 3, 7, 2};
		
		int testarr[] = {9,28,1,12,5,26,7,14,3,7,2};
		
		int newtest[] = {9,28,1,12,5,26,7,14,3,7,2};
		bubbleSort(arr);
		selectionSort(arr);
		insertionSort(arr);
		print(newtest);
		quickSort(newtest);
		quickSorttest(testarr);
		mergeSort(arr);
		iterativmergeSort(arr);
	}	
	
	public static void bubbleSort(int arr[]){
		
		boolean swapped = true;
		int j=0;
		while(swapped){ // loop till no swapping is there
			swapped = false; // make swaped as false
			j++; // to keep track of number of times the loop is run
			
			for(int i=0;i<arr.length - j;i++){ // inner loop untill the length - number of positons fixed at end
				
				if(arr[i]>arr[i+1]){// if any big number found swap it.
					
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swapped = true; // set swap true
				}			
			}
		}
		
	System.out.println("___________________BUBBLE SORT___________________");
	print(arr);
	}	
	
	public static void selectionSort(int arr[]){
		
		
		int minIndex;
		int n = arr.length;
		
		for(int i=0;i<n;i++){
			
			minIndex = i;//assign minimum index as current
			
			for(int j=i+1;j<n;j++){ // iterate through all the other positions from i+1 to end				
				if(arr[j]<arr[minIndex]) // find minimum position of element
					minIndex = j;
			}
				
			if(minIndex!=i){// if the minimum position is found then swap to the i th position
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;				
			}						
		}		

		System.out.println("___________________SELECTION SORT___________________");
		print(arr);		
	}
	
	public static void insertionSort(int arr[]){
		
		int j, val;
		
		//val of i is 1. not 0. 
		for(int i=1;i<arr.length;i++){
			
		val = arr[i];//the value is iterated through the loop
		j=i; // to shift appropriately
		
			while(j>=0&&arr[j-1]>val){ //should be above 0 and also value greater than current.
				arr[j] = arr[j-1];
				j--;	
			}			
		}
		System.out.println("___________________INSERTION SORT___________________");
		print(arr);
	}
	
	public static void shellSort(int arr[]){
		//coursera
	}
	
	public static void quickSort(int arr[]){		
		quickSort(arr,0, arr.length-1);
		System.out.println("___________________QUICK SORT___________________");
		print(arr);		
	}
	
	
	
	static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2]; //middle element as pivot	     
	      System.out.println( "In Partition, Pivot is " + pivot + " pivot index is" + (left + right) / 2);
	      int tempnewpos = 0;
	      while (i <= j) {
	            while (arr[i] < pivot) //increase left untill it is lesser than pivot
	                  i++;
	            while (arr[j] > pivot) //decrease right untill it is greate than pivot
	                  j--;	            
	            if (i <= j) { //swap and do for others till left meets right
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      System.out.println("after partition the new index for pivot is" + tempnewpos);
	      return i;
	}
	 
	
	static int partition_withposreturn(int arr[], int left, int right) {
		int Pivotval = arr[left];
		int PivotPosition = left;
		for (int k = left + 1; k <= right; k++) {
			if (arr[k] < Pivotval) {				
				PivotPosition = PivotPosition + 1;
				swap(arr, PivotPosition, k, " <<<<< ");
			}			
		}
		
		swap(arr, left, PivotPosition , " outside");
		return PivotPosition;
	}
	
	static void swap(int a[], int i, int j, String printhelper) {
		System.out.println("Swapping :" + i + " & " + j  +" that is " + a[i] + " & " + a[j]  + " : " + printhelper);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int[] quickSort(int arr[], int left, int right) {
		System.out.println("____________________________________________________________________________________");	
		System.out.println("Before partition");
	      print(arr);  
		
		int index = partition(arr, left, right);// do partition. middle . left side is small. right side is large
	      System.out.println("partitioned array");
	      print(arr);
	     System.out.println("After partition , Index is: "+ index);
	      if (left < index - 1){// do left part except the middle one
	    	 // System.out.println("Left: "+ left + "index-1: "+ (index-1));
	    	  
	            quickSort(arr, left, index - 1);		
	      }
	      if (index < right){// do the right one excpet the middle one
	    	  //System.out.println("index: "+ index + "right: "+ right);
	            quickSort(arr, index, right);	// i crosses.. pivot hence only no index+1
	      }
	      
	      return arr;
	}
	
	
	//  TEST Does not WORK!! Quick Select should work
	static int partitiontest(int arr[], int left, int right, int position)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[position]; // length -k -1 position. 
	      int itr=0;
	      while (i <= j) {
	    	  itr++;
	            while (arr[i] < pivot) //increase left untill it is lesser than pivot
	                  i++;
	            while (arr[j] > pivot) //decrease right untill it is greate than pivot
	                  j--;
	            if (i <= j) { //swap and do for others till left meets right
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     System.out.println("No of Iterations taken : "+ itr);
	      return i;
	}
	 
	static int[] quickSorttest(int arr[], int left, int right, int position) {		 	  
	      partitiontest(arr, left, right, position);// do partition. middle . left side is small. right side is large	      
	      return arr;
	}

	public static void quickSorttest(int arr[]){
		int k = 8;
		System.out.println("___________________QUICK SORT - K biggest elements___________________after " + k + "position index" );
		System.out.println("Before finding biggest K elements");
		print(arr);
		quickSorttest(arr,0, arr.length-1,k);
		System.out.println("After finding biggest K elements");
		print(arr);
		
	}
	public static void mergeSort(int arr[]) {

		mergeSort_srt(arr, 0, arr.length-1);
		System.out.println("___________________MERGE SORT___________________");
		print(arr);
	}

	public static void mergeSort_srt(int array[], int lo, int n) {
		int low = lo;
		int high = n;
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		mergeSort_srt(array, low, middle);
		mergeSort_srt(array, middle + 1, high);
		
		//merge them both
		
		int end_low = middle;
		int start_high = middle + 1;
		
		
		while ((lo <= end_low) && (start_high <= high)) {
			if (array[low] < array[start_high]) {
				low++;
			} else {
				int Temp = array[start_high];
				for (int k = start_high - 1; k >= low; k--) { //shift to right and insert
					array[k + 1] = array[k];
				}
				array[low] = Temp; //insert
				low++;
				end_low++;
				start_high++;
			}
		}
	}

	public static void iterativmergeSort(int arr[]) {//TODO

	
		System.out.println(arr);
	}
	
	public void sortElements(int arr[], int k){

		for(int i=0;i<arr.length;i++){
		  for (int j=i+1; j< i+k && j<arr.length; j++){
			  if(arr[i] > arr[j]){
				  int temp = arr[j];
		   			arr[j] = arr[i];
		   			arr[i] = temp;		
			  }
		  }
		}
	}

	public static void print(int arr[]){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();		
	}
}
