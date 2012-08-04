package prep.ownimplementations;

public class KMP_mine {

	//O(m+n).
	static void preComputeData(char[] p, int Next[]) 
	{ 
	
	int i=2, sub =0;
	Next[0] = -1;
	Next[1] = 0;
	
	while(i<p.length){
		
		if(p[i -1 ]==p[sub]){ //we have a continued substring in p from the start of p
			sub = sub + 1;
			Next[i] = sub;
			i = i+ 1;
		}else if(sub >0){ //if the substring stops, fall back to the start
			sub = Next[sub];
		}
		else{//we weren’t in a substring, so use default value
			Next[i] = 0;
			i = i+ 1;
		}
	}
	} 
	
	static int MorrisPrat(char []p, char []s) 
	{ 
		int i, j;
		int[] Next = new int[p.length]; 
		/* Preprocessing */ 
		preComputeData(p, Next); 
		
		/* Searching */ 
		i = j = 0;
		
		// j for String
		// i for pattern
		while (j + i < s.length) 
		{ 
			if(p[i]==s[j+i]){
				
				
				if(i==p.length-1){
					return j;
				}
			i = i+ 1;
			}
			else{
				j = j+i - Next[i];
				
				if(Next[i] > -1){
					i = Next[i];
				}else{
					i = 0;
				}
			}
			
		} 
		
		return s.length;
		
	} 
	
	public static void main(String args[]) {
		
		char[] string= "abababca".toCharArray();
		char[] pattern= "bababca".toCharArray(); 
		 
		System.out.println((MorrisPrat(pattern,string)+ 1) + " Position in the String"); 		
	}
}


