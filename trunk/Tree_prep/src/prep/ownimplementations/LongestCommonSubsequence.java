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


/**

       A  G  C  G  A 
    0  0  0  0  0  0 
 C  0  0  0  1  1  1 
 A  0  1  1  1  1  2 
 G  0  1  2  2  2  2 
 A  0  1  2  2  2  3 
 T  0  1  2  2  2  3 
 A  0  1  2  2  2  3 
 G  0  1  2  2  3  3 
 A  0  1  2  2  3  4 
 G  0  1  2  2  3  4 
   
       A  G  C  G  A 
    .  .  .  .  .  . 
 C  .  ^  ^  \  <  < 
 A  .  \  <  ^  ^  \ 
 G  .  ^  \  <  \  ^ 
 A  .  \  ^  ^  ^  \ 
 T  .  ^  ^  ^  ^  ^ 
 A  .  \  ^  ^  ^  \ 
 G  .  ^  \  ^  \  ^ 
 A  .  \  ^  ^  ^  \ 
 G  .  ^  \  ^  \  ^ 
LCS=AGGA
   
       A  B  C  B  D  A  B 
    0  0  0  0  0  0  0  0 
 B  0  0  1  1  1  1  1  1 
 D  0  0  1  1  1  2  2  2 
 C  0  0  1  2  2  2  2  2 
 A  0  1  1  2  2  2  3  3 
 B  0  1  2  2  3  3  3  4 
 A  0  1  2  2  3  3  4  4 
   
       A  B  C  B  D  A  B 
    .  .  .  .  .  .  .  . 
 B  .  ^  \  <  \  <  <  \ 
 D  .  ^  ^  ^  ^  \  <  < 
 C  .  ^  ^  \  <  ^  ^  ^ 
 A  .  \  ^  ^  ^  ^  \  < 
 B  .  ^  \  ^  \  <  ^  \ 
 A  .  \  ^  ^  ^  ^  \  ^ 
LCS=BDAB
   
       c  h  i  m  p  a  n  z  e  e  s 
    0  0  0  0  0  0  0  0  0  0  0  0 
 h  0  0  1  1  1  1  1  1  1  1  1  1 
 u  0  0  1  1  1  1  1  1  1  1  1  1 
 m  0  0  1  1  2  2  2  2  2  2  2  2 
 a  0  0  1  1  2  2  3  3  3  3  3  3 
 n  0  0  1  1  2  2  3  4  4  4  4  4 
 s  0  0  1  1  2  2  3  4  4  4  4  5 
   
       c  h  i  m  p  a  n  z  e  e  s 
    .  .  .  .  .  .  .  .  .  .  .  . 
 h  .  ^  \  <  <  <  <  <  <  <  <  < 
 u  .  ^  ^  ^  ^  ^  ^  ^  ^  ^  ^  ^ 
 m  .  ^  ^  ^  \  <  <  <  <  <  <  < 
 a  .  ^  ^  ^  ^  ^  \  <  <  <  <  < 
 n  .  ^  ^  ^  ^  ^  ^  \  <  <  <  < 
 s  .  ^  ^  ^  ^  ^  ^  ^  ^  ^  ^  \ 
LCS=hmans



*/