package prep.arraydupelemination;

import java.util.ArrayList;
import java.util.Arrays;

public class DuplicateElemination {

	/**
	 * Remove duplicated elements in a array using copy of.. something like i
	 */
	public static void main(String[] args) {
		
		
	/*	Integer j = new Integer(1);
		Integer k = new Integer(1);
		
		String s = "king";
		String s1 = "king";
		
		String ii = new String("king");
		String ii1 = new String("king");
		
		Double g1 = new Double(1.00);
		Double g2 = new Double(1.00);
		
		
		DuplicateElemination d1 = new DuplicateElemination();
		DuplicateElemination d2 = new DuplicateElemination();
		
		System.out.println(j.hashCode()+ ":" + k.hashCode());
		System.out.println(s.hashCode()+ ":" + s1.hashCode());
		System.out.println(ii.hashCode()+ ":" + ii1.hashCode());
		System.out.println(d1.hashCode()+ ":" + d2.hashCode());
		System.out.println(g1.hashCode()+ ":" + g2.hashCode());
		
		*/
		
		int arr[] = {1, 2, 3, 4, 4, 6, 7};
		System.out.println("Before");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ "  ");
		arr = eleminate(arr);
		System.out.println();
		System.out.println("After");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ "  ");
		System.out.println();
		int my_array1[] = {1, 1, 2, 3, 5, 6, 6, 7, 10, 25, 100, 123, 123};
		
		
		
		System.out.println("Before");
		for(int i=0;i<my_array1.length;i++)
			System.out.print(my_array1[i]+ "  ");
		System.out.println();
		System.out.println("PRINT OUT UNIQUE FROM SORTED");
		
		
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
		int my_array3[] = {1, 2, 1, 3, 1};
		
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
			System.out.print(my_array7[i]+ "  ");
		
	}

	private static int[] eleminate(int[] arr) {

		int length = arr.length;
		for(int i=0; i<length;i++){		
			
			for(int j=i+1; j<length;j++){				
				
				if(arr[i]==arr[j]){
	
					int dupstart = j;
					int dupend = j;
					
					int m = j;
					
					while(m<length){						
						if(arr[j]==arr[m])
							dupend++;
						else
							break;
						
						m++;						
					}
					
					int no_of_dup = dupend - dupstart;
					length = length - no_of_dup;
					
					for(int s=dupstart;(s + no_of_dup) <arr.length;s++){	
						arr[s]= arr[s+no_of_dup];
					}
				}
				
			}
		}

		return Arrays.copyOf(arr, length);
	}

	

}
