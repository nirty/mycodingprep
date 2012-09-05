package backtracking;

public class HamiltonianCircuits {

	boolean[][] W;
	int vertices;
	
	int[] vindex;
	
	public void findRoute(boolean[][] ww, int noofvertices){
	
		this.W = ww;
		vertices = noofvertices;
		vindex = new int[noofvertices];
		
		vindex[0]= 0;
		recurseHamiltonian(0);
	}

	private void recurseHamiltonian(int i) {
		
		
		if(isPromising(i)){
			
			if(i==vertices-1){				
				System.out.println("Found out Paths");
				for(int k=0;k<vertices;k++)
					System.out.println(vindex[k] + 1);
				
				System.out.println( vindex[0] + 1);
			}	
			else{				
				for(int j=1;j<vertices;j++){
					vindex[i+1] = j;
					recurseHamiltonian(i+1);	
				}
			}
		}
	}

	private boolean isPromising(int i) {
		
		if(i>=vertices)
			return false;
		
		if(i==vertices-1 &&! W[vindex[i]][vindex[0]]) // vertices - 1 and 0 are same ?
			return false;
		
		if(i>0 &&! W[vindex[i-1]][vindex[i]]) //previous one and me are same?
			return false;
		
		int j=0;
		while (j<i){ // everyone till me are different ?
			if(vindex[j] == vindex[i])
				return false;
			j++;
		}
		
		return true;
		
	}
	
	public static void main(String args[]){
		
		HamiltonianCircuits hc = new HamiltonianCircuits();
		
		boolean[][] W = { { false,true,true,false,false,false,true,true},
						  { true,false,true,false,false,false,true,true},
						  { true,true,false,true,false,true,false,false},
						  { false,false,true,false,true,false,false,false},
						  { false,false,false,true,false,true,false,false},
						  { false,false,true,false,true,false,true,false},
						  {	true,true,false,false,false,true,false,true},
						  { true,true,false,false,false,false,true,false}};
		
		hc.findRoute(W, 8);
	}
}
