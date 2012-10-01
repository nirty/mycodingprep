package backtracking;

public class StableMarriage {

	int[][] mensrankingwomen;
	int[][] womensrankingmen;
	
	int[] menspair;
	int[] womenspair;
	
	int[][] menswomenrank;
	int[][] womensmenrank;
	
	boolean[] singlewomen;
	
	int mens;
	int womens;
	
	public void findstable(int[][] wmr,int [][] mwr, int count){
		
		mensrankingwomen = wmr;
		womensrankingmen = mwr;
		
		this.mens = count;
		this.womens = count;
		
		menswomenrank = new int [count + 1][count +1];
		womensmenrank = new int [count + 1][count +1];
		
		menspair = new int[count + 1];
		womenspair = new int[count +1];
		
		for(int i=1;i<=mens;i++){
			for(int j=1;j<=womens;j++){
				//System.out.println(i + " : " + j);
				menswomenrank[i][mensrankingwomen[i][j]] = j;
			}
		}
		
		singlewomen = new boolean[count + 1];
		
		for(int i=1;i<=womens;i++){
			singlewomen[i] = true;
			for(int j=1;j<=mens;j++)
				womensmenrank[i][womensrankingmen[i][j]] = j;
		}		
		
		System.out.println(" Given Mens Preference order");
		printmatrix(mensrankingwomen,mens);
		
		System.out.println("  Mens - Womens Rank");
		printmatrix(menswomenrank,mens);
		
		System.out.println(" Given Womens Preference order");
		printmatrix(womensrankingmen,womens);
		
		System.out.println("  Mens - Womens Rank");
		printmatrix(womensmenrank,womens);	
		
		recurseStable(1);
	}
	
	
	
	public void recurseStable(int ithmen){
		
		
		for(int ithwomen=1; ithwomen<=womens; ithwomen++){
			
			if(singlewomen[ithwomen] && stable(ithmen,ithwomen)){
				
				menspair[ithmen] = ithwomen;
				womenspair[ithwomen] = ithmen;
				
				singlewomen[ithwomen] = false;
				
				if(ithmen<=mens -1)
					recurseStable(ithmen +1);
				else{
					for(int h=1;h<=mens;h++)
						System.out.println( "( " + h + " , " + menspair[h]+ " ) ");
				}
			}
		}
		
	}
	
	
	
	private boolean stable(int ithmen, int ithwomen) {
		
		
		
		return false;
	}



	public void printmatrix(int[][] arr,int c){
		
		for(int i= 1 ; i<=c;i++){
			for(int j =1;j<=c;j++){
				System.out.print( arr[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main (String args[]){
		
		int mens[][] = { {0, 0, 0, 0, 0},
						 {0, 2, 4, 1, 3},
						 {0, 3, 1, 4, 2},
						 {0, 2, 3, 1, 4},
						 {0, 4, 1, 3, 2}
					   };
		
		int womens[][] = { {0, 0, 0, 0, 0},
						   {0, 2, 1, 4, 3},
						   {0, 4, 3, 1, 2},
						   {0, 1, 4, 3, 2},
						   {0, 2, 1, 4, 3}
			   			 };
		
		
		StableMarriage st = new StableMarriage();
		st.findstable(mens, womens, 4);
		
		
	}
}
