package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddArrays {

	public static void main(String[] args) {

		int[] int1 = { 1, 2, 3, 4 };
		int[] int2 = { 8, 5, 6, 7, 8 };
		int[] int3 = addTwo(int1, int2);
		System.out.println(Arrays.toString(int3));
		System.out.println(Arrays.toString(addArrays(int1,int2)));
	}

	public static int[] addTwo(int[] int1, int[] int2)
	{
		boolean addPoint = false;
		ArrayList<Integer> newList = new ArrayList<Integer>();



		for (int i = int1.length-1; i >=0; i--)
		{
			int newSingleValue = int1[i] + int2[i];
			if (addPoint)
			{
				newSingleValue = newSingleValue + 1;
				addPoint = false;
			}

			if (newSingleValue >= 10)
			{
				addPoint = true;
				newSingleValue = newSingleValue - 10;
			}
			newList.add(newSingleValue);
    }
		Collections.reverse(newList);

		 int[] result = new int[newList.size()];
		 int i = 0;
		 for (Integer n : newList) {
		        result[i++] = n;
		    }
		
		return result;
}
	
	public static int[] addArrays(int[] arr1, int[] arr2)
	{
		//make sure the arguments aren't null or empty
		//return of null indicates the two array can't be added.
		if(arr1 == null || arr1.length == 0)
			return arr2;
		
		if(arr2 == null || arr2.length == 0)
			return arr1;
		
		//see if the arrays are the same size
		if(arr1.length != arr2.length)
		{
			//pad the array which has lesser elements with zero(s) to ensure the correct columns are added.
			int[] temp;
			if(arr1.length < arr2.length)
			{
				//arr1 is less


//make copy of arr1
				temp = arr1;
				//start index in new array
				int start = arr2.length - arr1.length;
				//pad with zeros; default value of int is zero.
				arr1 = new int[arr2.length];



//copy original content
				for (int j = start; j < arr1.length; j++)
					arr1[j] = temp[j-start];



			}
			else
			{
				//arr2 is less
				
				//make copy of arr2
				temp = arr2;
				//start index in new array
				int start = arr1.length - arr2.length;
				//pad with zeros; default value of int is zero.
				arr2 = new int[arr1.length];



//copy original content
				for (int j = start; j < arr2.length; j++)
					arr2[j] = temp[j-start];
			}
		}
		//arrays should be the same size at this point.
		//create sum array and plus one in case there is a carry over
		int[] sum = new int[arr1.length+1];
		int carryOver = 0;
		for (int i = arr1.length-1; i > -1; i--) {
			//calculate sum on column. save it to in a variable so you wont have to keep repeating addition
			int summation = carryOver + arr1[i] + arr2[i];
			//store sum in array. ex. 18 mod 10 = 8 or 20 mod 10 = 0 or 25 mod 10 = 5.
			sum[i+1]= summation % 10;
			//calculate carry over. ex. 18 div 10 = 1 or 20 div 10 = 0 or 25 div 10 = 2.
			carryOver = summation / 10;
		}
		//if we still have a carryover form the first indexes of arr1 and arr2 then put it in the sum array
		if(carryOver > 0)
			sum[0] = carryOver;
		else
			//step isn't necessary but if you do not want to copy an array with an extra element that fill with zero only copy what you need.
			sum = Arrays.copyOfRange(sum, 1, sum.length);
		return sum;
	}
	
}