package prep.maxsubarray;

import java.util.Arrays;

public class ThreeElementsSum {
	
	
	// http://www.geeksforgeeks.org/archives/484
	static void checkForSum3 (int arr[], int sum) { 		
			Arrays.sort(arr);	
			for(int k=0;k<arr.length;k++)
				System.out.print(arr[k] +"\t");
			System.out.println();
			
			
	        for (int i = 0; i < arr.length ; i++) {
	                int left = i + 1;
	                int right = arr.length - 1;

	                while (right > left) {
	                        if (arr[right] + arr[left] + arr[i] - sum == 0) {
	                        	System.out.println("values are"+ arr[i]+":"+ arr[left]+":"+ arr[right]);
	                                return;
	                        }
	                        if (arr[right] + arr[left] + arr[i] - sum > 0)
	                                right--;
	                        else
	                                left++;

	                }

	        }
	        return;
	}
	
	static void checkForSum2 (int arr[], int sum) { 		
		
		
		for(int k=0;k<arr.length;k++)
			System.out.print(arr[k] +"\t");
		System.out.println();
                int left = 0;
                int right = arr.length - 1;

                while (right > left) {
                        if (arr[right] + arr[left] - sum == 0) {
                        	System.out.println("values are "+ arr[left]+":"+ arr[right]);
                               // return;
                        }
                        if (arr[right] + arr[left] - sum > 0)
                                right--;
                        else
                                left++;

                }      
        return;
	}
	
	static void checkForSum4 (int arr[], int sum) {
		
		
		int new_arr[] = new int[arr.length *arr.length];
		
		int pos = 0;
		for(int k=0;k<arr.length;k++)
			for(int l=0;l<arr.length;l++){
				new_arr[pos] = arr[k] *arr[l];
				pos++;
			}
		
		Arrays.sort(new_arr);
		for(int k=0;k<new_arr.length;k++)
			System.out.print(new_arr[k] +"\t");
		System.out.println();
	
		 int left = 0;
         int right = new_arr.length - 1;

         while (right > left) {
                 if (new_arr[right] + new_arr[left] - sum == 0) {
                 	System.out.println("values are "+ new_arr[left]+":"+ new_arr[right]);
                        // return;
                 }
                 if (new_arr[right] + new_arr[left] - sum > 0)
                         right--;
                 else
                         left++;

         }      
        return;
}
	
	
	
	
	public static void main(String args[]){		
		int arr4[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4};	
		//checkForSum2 (arr4, 3);
		//checkForSum3(arr4,5);
		checkForSum4(arr4,10);
	}

}
