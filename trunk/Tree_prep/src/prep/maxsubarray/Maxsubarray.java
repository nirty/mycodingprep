package prep.maxsubarray;

public class Maxsubarray {

	
	public static void main(String[] args) {
		
		int arr[] = { 31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
		System.out.println("Before");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ "  ");
		int sum = maxsum(arr);
		
		int arr1[]  = {11, -12, 15, -3, 8, -9, 1, 8, 10, -2};
		System.out.println("Before");
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+ "  ");
		int sum1 = maxsum(arr1);
		
		int arr2[]  = {5, 2, -1};
		System.out.println("Before");
		for(int i=0;i<arr2.length;i++)
			System.out.print(arr2[i]+ "  ");
		int sum2 = maxsum(arr2);
		
		int arr3[]  = {-5,-10,-15, -2, -20,-31};
		System.out.println("Before");
		for(int i=0;i<arr3.length;i++)
			System.out.print(arr3[i]+ "  ");
		int sum3 = maxsum(arr3);

		int arr4[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println("Before");
		for(int i=0;i<arr4.length;i++)
			System.out.print(arr4[i]+ "  ");
		int sum4 = maxsum(arr4);
	}

	private static int maxsum(int[] arr) {
		
		System.out.println();
		int max_start = 0;
		int max_end = 0;	
		
		int curr_start = 0;
		
		int maxsum = arr[0];
		int currsum = arr[0];
		int maxnegative = arr[0];
		boolean negative = true;	
		
		for(int i=1 ;i<arr.length;i++){
			
			if(arr[i]>0){
				negative = false;
			}
			else{
				
				if(arr[i] > maxnegative)
					maxnegative = arr[i];
			}					
			
			if(currsum<0){
				currsum = 0;
				curr_start = i;
			}
			
			currsum = currsum + arr[i];
				
			if(currsum>maxsum){
					
				maxsum = currsum;
				max_start = curr_start;
				max_end = i;
			}		
			
		}
		
		System.out.println("Maxsum" + ": " + maxsum);
		System.out.println("starting" + ": "+ max_start);
		System.out.println("Ending" + " :"+ max_end);
		if(negative)
			System.out.println("Maximum negative is" + maxnegative);
		System.out.println("-----------------------------------------");
		return maxsum;
	}

}
