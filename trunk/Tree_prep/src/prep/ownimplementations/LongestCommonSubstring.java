package prep.ownimplementations;

public class LongestCommonSubstring {
	
	
	public static String getLcs(String word1,String word2){
		
		
		int m[][] = new int[word1.length()+1][word2.length()+1];
		int i, j;
		  for (i = 0; i < word1.length()+1; i++) m[i][0] = 0;
		  for (j = 0; j < word2.length()+1; j++) m[0][j] = 0;
		  
		  int max = 0;
		  int max_i = -1;
		  int max_j = -1;

		  for (i = 0; i < word1.length(); i++){
		    for (j = 0; j < word2.length(); j++){
		      if (word1.charAt(i)== word2.charAt(j)){
		        m[i+1][j+1] = m[i][j] + 1;
		      }
		      else{
		        m[i+1][j+1] = 0; 
		      }

		      if (max < m[i+1][j+1]){
		         max = m[i+1][j+1];
		         max_i = i;
		         max_j = j;
		      }
		    }
		  }
		  return word1.substring(max_i - max + 1, max);
	
		
	}
	
	static String longestCommonPrefix(String str1, String str2)
	{
	   int idx = 0;
	   while (idx < str1.length() && idx < str2.length()){
	      if (str1.charAt(idx) == str2.charAt(idx)) {
	    	  idx++; 
	    	  continue;
	      } 
	      break;
	   }

	   return str1.substring(0, idx);
	}
	
	public static void main(String args[]){
		
		System.out.println("LCS : " +getLcs("Hello, this is a test","Well, I don't know whether this is a test. Hello"));
		System.out.println("LCP : "+ longestCommonPrefix("this is a test","this is a test. Hello"));
	}
	 
}

/**

    a l o h a 
  0 0 0 0 0 0 
h 0 0 0 0 1 0 
e 0 0 0 0 0 0 
l 0 0 1 0 0 0 
l 0 0 1 0 0 0 
o 0 0 0 2 0 0 
LCS=lo

    a b b a 
  0 0 0 0 0 
b 0 0 1 1 0 
a 0 1 0 0 2 
b 0 0 2 1 0 
a 0 1 0 0 2 
LCS=ba

    T u n e d   B o y e r - M o o r e   a l g o r i t h m 
  0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
Q 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
u 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
i 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 
c 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
k 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
  0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 
S 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
e 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 
a 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 
r 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 
c 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
h 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 
  0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 
a 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 
l 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 
g 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 0 0 0 0 0 0 
o 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 1 0 0 0 0 0 0 5 0 0 0 0 0 
r 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 2 0 0 0 0 0 0 6 0 0 0 0 
i 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 0 0 
t 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 8 0 0 
h 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 0 
m 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 
LCS= algorithm

*/
