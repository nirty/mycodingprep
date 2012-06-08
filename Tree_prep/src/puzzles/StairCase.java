package puzzles;

public class StairCase {

	public static int recurseSteps(int steps){
		
		if(steps == 1)return 1;
		if(steps == 2)return 2;
		if(steps == 3)return 4;
		
		return recurseSteps(steps-1) + recurseSteps(steps-2) + recurseSteps(steps -3);
	}
	
	public static int iterateSteps(int steps){
		
		if(steps == 1)return 1;
		if(steps == 2)return 2;
		if(steps == 3)return 4;
		
		
		
		int[] ways = {1,2,4};
		
		int current = 3;
		int total = 0;
		while(current < steps){
			
			total = ways[0] +ways[1]+ways[2];
			ways[0] = ways[1];
			ways[1] = ways[2];
			ways[2] = total;
			
			current++;
		}
		
		return ways[2];
	}
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println("Recursively :" + recurseSteps(40) + "Time:" + ((long)System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		System.out.println("iteratively :" + iterateSteps(40) + "Time :" + ((long)System.currentTimeMillis()-start));
	}

}
