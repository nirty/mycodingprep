package permuations;

import java.util.ArrayList;

public class iterativePermutation {

	static int nextPermLexicographically(int perm[], int length) {

		// Find the spot that needs to change.
		int i = length - 1;
		while (i > 0 && perm[i] < perm[i - 1])
			i--;

		i--; // Advance to swap location.

		// So last perm doesn't cause a problem.
		if (i == -1)
			return 1;

		// Find the spot with which to swap.
		int j = length - 1;
		while (j > i && perm[j] < perm[i])
			j--;

		// Swap it.
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;

		// reverse from index i+1 to length-1.
		int k, m;
		for (k = i + 1, m = length - 1; k < m; k++, m--) {
			temp = perm[k];
			perm[k] = perm[m];
			perm[m] = temp;
		}

		return 0;
	}

	static void printperm(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "\t");
		System.out.println();
	}

	public static ArrayList<String> QuickPermute(String input)
	{
		ArrayList<String> l1=new ArrayList<String>();
		String output;
		int i, j;
		char t;
		StringBuffer temp = new StringBuffer();
		char s[] = input.toCharArray();
		int N = input.length();
		int p[] = new int[N];
		l1.add(input);
		
		for (i = 0; i < N; i++)
		{
			p[i] = i;
		}

		i = 1;

		while (i < N)
		{
			p[i] = p[i]- 1;
			if ((i % 2) != 0)
				j = p[i];
			else
				j = 0;
			
			System.out.println("INPUT CHARACTER ARRAY");
			for(int hu = 0 ;hu <s.length;hu++){
				System.out.print(s[hu] + "\t" );
			}
			System.out.println();

			t = s[j];
			s[j] = s[i];
			s[i] = t;

			for (int k = 0; k < N; k++)
			{
				temp.append(s[k]);
			}

			output = new String(temp);
			
			
			if (l1.contains(output) == false){ //takes into account of the repitive words formed				
				l1.add(output);
			}else{
				System.out.println("MISSED PERMUTATION__________________");
			}
			
			System.out.println(" ____ i: "+i  + " ____ j: "+j);

			
			
			temp.delete(0, N);
			i = 1;
			
			System.out.println("Array of P before");
			for(int hu = 0 ;hu <p.length;hu++){
				System.out.print(p[hu] + "\t" );
			}
			System.out.println();
			
			while ( i< p.length && p[i] == 0)
			{
				p[i] = i;
				i++;
			}
			
			System.out.println("Array of P after");
			for(int hu = 0 ;hu <p.length;hu++){
				System.out.print(p[hu] + "\t" );
			}
			System.out.println();
			System.out.println(" I === " + i);
			System.out.println("__________________________________________________________________");
		}
		
		return l1;
	}
	
	
	

	public static void main(String args[]) {

		int arr[] = {1, 2, 3};
		System.out.println("LEXICOGRAPHIC PERMUTATIONS");
		printperm(arr);
		int done = 1;
		do {
			done = nextPermLexicographically(arr, arr.length);
			if (done == 0) {
				printperm(arr);
			}
		} while (done == 0);
		
		System.out.println("QUICK PERM PERMUTATIONS");
		
		ArrayList<String> result = QuickPermute("abcd");
		System.out.println(result);

	}
	
	
}
