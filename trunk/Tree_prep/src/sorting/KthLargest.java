package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class KthLargest {

	public static void kthlargest(int arr[], int k) {
		kthlargest_partioning(arr, 0, arr.length - 1,
				Math.abs(k - arr.length));
	}

	public static void kthlargest_partioning(int arr[], int start, int end,
			int k) {
		if (start <= end) {
			System.out
					.println("____________________________________________________________________________________");
			System.out.println("Before partioning");
			print(arr);

			Random g_Generator = new Random();
			int pivotindex = g_Generator.nextInt(end - start + 1) + start;
			System.out.println("Start :" + start + " End: " + end + " Pivot position: " + pivotindex + " pivot value "+ arr[pivotindex] + " K value: " + k);

			int pivotValue = arr[pivotindex];
			int newindexposofPIvot = RandomPartition(arr, start, end, pivotindex);

			System.out.println(" New index of " + pivotValue + " is "+ newindexposofPIvot);

			if (k == newindexposofPIvot)
				System.out.println(" RESULT ********" + arr[newindexposofPIvot]);
			else if (k < newindexposofPIvot)
				kthlargest_partioning(arr, start, newindexposofPIvot - 1, k);
			else
				kthlargest_partioning(arr, newindexposofPIvot + 1, end, k);

		}

	}

	private static int RandomPartition(int[] arr, int start, int end,
			int pivotindex) {
		swap(arr, start, pivotindex, " Random to Left");
		return partition(arr, start, end);
	}

	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static int partition(int arr[], int left, int right) {
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

	/**
	 * Swaps two entries of the array.
	 * 
	 * @param i
	 *            the first position to swap
	 * @param j
	 *            the second position to swap
	 */
	static void swap(int a[], int i, int j, String printhelper) {
		System.out.println("Swapping :" + i + " & " + j  +" that is " + a[i] + " & " + a[j]  + " : " + printhelper);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {

		int[] test_array1 = { 5, 2, 9, 1, 6 };
		int arr[] = { 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		int testarr[] = { 9, 28, 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		print(testarr);
		int pos = 2;
		System.out.println("K th Largest number" + pos);
		kthlargest(testarr, pos);

		print(testarr);
	}

}
