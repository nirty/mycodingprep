package sorting;

public class AllSortings {

	
	public static void main(String args[]){
		
		//int arr[] = {12,9,4,99,120,1,3,10};
		int arr[] =  {1, 12, 5, 26, 7, 14, 3, 7, 2};
		bubbleSort(arr);
		selectionSort(arr);
		insertionSort(arr);
		quickSort(arr);
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
	     
	      return i;
	}
	 
	static int[] quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);// do partition. middle . left side is small. right side is large
	      if (left < index - 1){// do left part except the middle one
	            quickSort(arr, left, index - 1);		
	      }
	      if (index < right){// do the right one excpet the middle one
	            quickSort(arr, index, right);	
	      }
	      
	      return arr;
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

	public static void iterativmergeSort(int arr[]) {

	
		System.out.println(arr);
	}

	public static void print(int arr[]){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();		
	}
}
