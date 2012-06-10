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

