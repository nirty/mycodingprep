package backtracking;

public class GraphColoring {
	
	int  m_colors;
	int[] vcolors;
	int noofvertex;
	boolean[][] W;
	
	
	public void findColors(boolean[][] adjacency, int noofcolors, int noofvertex){		
		W = adjacency;
		m_colors = noofcolors;
		vcolors = new int[noofvertex];
		for(int i=0;i<vcolors.length;i++)
			vcolors[i] = -1;
		this.noofvertex = noofvertex;
		vcolors[0] = 0;
		backtrackcolors(0);
	}
	
	
	private void backtrackcolors(int i) {

		if(IsPromising(i)){			
			if(i==noofvertex - 1){
				for(int k=0;k<noofvertex;k++)
					System.out.println((vcolors[k]+1) +  "  ");
			}
			
			if(i+1<noofvertex){
				for(int j=0; j<m_colors;j++){
					vcolors[i+1] = j;
					backtrackcolors(i+1);
				}
			}
		}
		
	}


	private boolean IsPromising(int i) {		
		for(int j=0;j<noofvertex;j++){			
			if(W[i][j] == true && vcolors[i]==vcolors[j])
				return false;
		}		
		return true;
	}


	public static void main(String args[]){
		
		GraphColoring gc = new GraphColoring();
		boolean [][]W = {{false, true, true, true},
						 {true,false,true, false},
						 {true,true,false,true },
						  {true,false,true,false}};
				
		gc.findColors(W,3,4);
		
		
	}

}
