package prep.ownimplementations;

public class LongestCommonSubsequence {

	
	public static int[][] compute_m(String s1, String s2){
		
		int[][] m  = new int[s1.length()+1][s2.length()+1];

		  int i, j;
		  for (i = 0; i < s1.length()+1; i++) m[i][0] = 0;
		  for (j = 0; j < s2.length()+1; j++) m[0][j] = 0;
		  
		  for (i = 0; i < s1.length(); i++){
		    for (j = 0; j < s2.length(); j++){
		      if (s1.charAt(i) == s2.charAt(j)){
		        m[i+1][j+1] = m[i][j] + 1;
		      }
		      else{
		        m[i+1][j+1] = (m[i][j+1] > m[i+1][j])? m[i][j+1] : m[i+1][j]; 
		      }
		    }
		  }
		  return m;
	}
	
	
	public static String get_lcs(int[][] m,String s1,int i,int j){
		
		String s= "";
		  if (i == 0 || j == 0) 
			  return "";

		  if (m[i-1][j-1] < m[i][j] && m[i][j-1] < m[i][j] && m[i-1][j] < m[i][j]){
		    s = get_lcs(m, s1, i-1, j-1);
		    s = s + s1.substring(i-1, i);
		  }
		  else if (m[i-1][j] == m[i][j]){
		    s = get_lcs(m, s1, i-1, j);
		  }
		  else {
		    s = get_lcs(m, s1, i, j-1);
		  }

		  return s;	
	}
	
	public static void main(String args[]){
		
		String s1 = "Hello, this is a test";
		String s2 = "Well, I don't know whether this is a test. Hello";
		int m[][] = compute_m(s1,s2);
		System.out.println("LCS : " +get_lcs(m,s1,s1.length(),s2.length()));
	}
}