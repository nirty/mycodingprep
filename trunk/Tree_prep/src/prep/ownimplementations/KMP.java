package prep.ownimplementations;

public class KMP {

	static void preComputeData(char[] x, int m, int Next[]) 
	{ 
	
	int i, j;
	i = 0; 
	j = Next[0] = -1;
	while (i < m)
	{ 
		while (j > -1 && x[i] != x[j]) 
			j = Next[j]; 
		Next[++i] = ++j; 
		} 
	} 
	
	static void MorrisPrat(char []x, int m, char []y, int n) 
	{ 
		int i, j;
		int[] Next = new int[1000]; 
		/* Preprocessing */ 
		preComputeData(x, m, Next); 
		
		/* Searching */ 
		i = j = 0;
		while (j < n) 
		{ 
			while (i > -1 && x[i] != y[j]) 
				i = Next[i]; 
			i++; 
			j++; 	
			
			if (i >= m) 
			{ 
				System.out.println("\nMatch found at : " + (j - i + 1) + "position in the string"); 
				i = Next[i];
				
			} 
			
		} 
		
	} 
	
	public static void main(String args[]) {
		
		char[] string= "abababca".toCharArray();
		char[] pattern= "bca".toCharArray(); 
		MorrisPrat(pattern,pattern.length,string,string.length); 
		System.out.println(); 		
	}
}


