package prep.ownimplementations;

public class BoyerMoore_GsBc {

	static int ASIZE = 1000;
	static int XSIZE = 1000;
	
	static void preBmBc(char []x, int m, int bmBc[]) {
		   int i;
		 
		   for (i = 0; i < ASIZE; ++i)
		      bmBc[i] = m;
		   for (i = 0; i < m - 1; ++i)
		      bmBc[x[i]] = m - i - 1;
	}
	
	static void suffixes(char []x, int m, int []suff) {
		   int f = 0, g = 0, i = 0;
		 
		   suff[m - 1] = m;
		   g = m - 1;
		   for (i = m - 2; i >= 0; --i) {
		      if (i > g && suff[i + m - 1 - f] < i - g)
		         suff[i] = suff[i + m - 1 - f];
		      else {
		         if (i < g)
		            g = i;
		         f = i;
		         while (g >= 0 && x[g] == x[g + m - 1 - f])
		            --g;
		         suff[i] = f - g;
		      }
		   }
	}
	
	 
	static void preBmGs(char []x, int m, int bmGs[]) {
		   int i, j;
		   int[] suff = new int[XSIZE];
		 
		   suffixes(x, m, suff);
		 
		   for (i = 0; i < m; ++i)
		      bmGs[i] = m;
		   j = 0;
		   for (i = m - 1; i >= 0; --i)
		      if (suff[i] == i + 1)
		         for (; j < m - 1 - i; ++j)
		            if (bmGs[j] == m)
		               bmGs[j] = m - 1 - i;
		   for (i = 0; i <= m - 2; ++i)
		      bmGs[m - 1 - suff[i]] = m - 1 - i;
		}
	
	static void BM(char []x, int m, char []y, int n) {
		   int i, j; 
		   int[] bmGs = new int[XSIZE];
		   int[] bmBc = new int[ASIZE];
		 
		   /* Preprocessing */
		   preBmGs(x, m, bmGs);
		   preBmBc(x, m, bmBc);
		 
		   /* Searching */
		   j = 0;
		   while (j <= n - m) {
		      for (i = m - 1; i >= 0 && x[i] == y[i + j]; --i);
		      if (i < 0) {
		         System.out.println(j + " Position in the String");
		         j += bmGs[0];
		      }
		      else
		         j += Math.max(bmGs[i], bmBc[y[i + j]] - m + 1 + i);
		   }
		}
	
	
	public static void main(String args[]){
		
		char[] string= "oooooooooooommmmmmmmmmzzzzzzzzzzzbababcaz".toCharArray();
		char[] pattern= "bababcaz".toCharArray(); 
		 
		BM(pattern,pattern.length,string, string.length);
		
	}
	
}



	 
	 
	
	
	 
	 
	