package prep.arraydupelemination;

import java.util.ArrayList;
import java.util.Arrays;

public class zerospushback {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int arr[] = {0, 1, 0, 0, 4, 4, 0, 6, 0, 0, 0, 7, 0};
		System.out.println("Before" + arr.length);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ "  ");
		
		arr = eleminate(arr);
		System.out.println();
		System.out.println("After" + arr.length);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ "  ");
		System.out.println();
		int my_array1[] = {1, 1, 2, 3, 5, 6, 6, 7, 10, 25, 100, 123, 123};
		
	/*	System.out.println("Before");
		for(int i=0;i<my_array1.length;i++)
			System.out.print(my_array1[i]+ "  ");
		my_array1 = eleminate(my_array1);
		System.out.println();
		System.out.println("After");
		for(int i=0;i<my_array1.length;i++)
			System.out.print(my_array1[i]+ "  ");
		
		System.out.println();
		int my_array2[] = {1, 2, 3, 5, 6};
		
		System.out.println("Before");
		for(int i=0;i<my_array2.length;i++)
			System.out.print(my_array2[i]+ "  ");
		my_array2 = eleminate(my_array2);
		System.out.println();
		System.out.println("After");
		for(int i=0;i<my_array2.length;i++)
			System.out.print(my_array2[i]+ "  ");
		
		System.out.println();
		int my_array3[] = {1, 1, 1, 1, 1};
		
		System.out.println("Before");
		for(int i=0;i<my_array3.length;i++)
			System.out.print(my_array3[i]+ "  ");
		my_array3 = eleminate(my_array3);
		System.out.println();
		System.out.println("After");
		for(int i=0;i<my_array3.length;i++)
			System.out.print(my_array3[i]+ "  ");
		
		System.out.println();
		int my_array4[] = {123, 123};
		
		System.out.println("Before");
		for(int i=0;i<my_array4.length;i++)
			System.out.print(my_array4[i]+ "  ");
		my_array4 = eleminate(my_array4);
		System.out.println();
		System.out.println("After");
		for(int i=0;i<my_array4.length;i++)
			System.out.print(my_array4[i]+ "  ");
		
		System.out.println();
		int my_array5[] = {1, 123, 123};
		
		System.out.println("Before");
		for(int i=0;i<my_array5.length;i++)
			System.out.print(my_array5[i]+ "  ");
		my_array5 = eleminate(my_array5);
		System.out.println();
		System.out.println("After");
		for(int i=0;i<my_array5.length;i++)
			System.out.print(my_array5[i]+ "  ");
		
		System.out.println();
		int my_array6[] = {123, 123, 166};
		System.out.println("Before");
		for(int i=0;i<my_array6.length;i++)
			System.out.print(my_array6[i]+ "  ");
		System.out.println();
		my_array6 = eleminate(my_array6);
		System.out.println("After");
		for(int i=0;i<my_array6.length;i++)
			System.out.print(my_array6[i]+ "  ");
		
		System.out.println();
		int my_array7[] = {1, 2, 8, 8 , 24, 60, 60, 60, 60, 75, 100, 100, 123};
		
		System.out.println("Before");
		for(int i=0;i<my_array7.length;i++)
			System.out.print(my_array7[i]+ "  ");
		System.out.println();
		my_array7 = eleminate(my_array7);
		System.out.println("After");
		for(int i=0;i<my_array7.length;i++)
			System.out.print(my_array7[i]+ "  ");*/
		
	}

	private static int[] eleminate(int[] arr) {

		int length = arr.length;
		for(int i=0; i<length;i++){
				
				if(arr[i]== 0){
	
					int zerostart = i;
					int zeroend = i;
					
					int m = i;
					
					while(m<length){						
						if(arr[m] == 0)
							zeroend++;
						else
							break;
						
						m++;						
					}
					
					int no_of_zero = zeroend - zerostart;
					length = length - no_of_zero;
					
					for(int s=zerostart;(s + no_of_zero) <arr.length;s++){	
						arr[s]= arr[s+no_of_zero];
					}
				}
				
			
		}

		
		for(int k = length; k<arr.length;k++){
			arr[k] =0;
		}
		return arr;
	}

	

}
