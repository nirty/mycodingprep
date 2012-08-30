package backtracking;

import java.util.ArrayList;

public class HorseTour {

	int rows = 5;
	int cols = 5;
	public boolean[][] visitedsquares = new boolean[rows][cols];
	
	square[] sucesspaths = new square[rows*cols];
	
	public void findhorsepaths(){
		
		
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				visitedsquares[i][j] = false;
		visitedsquares[0][0] = true;
		square visitedsq = new square();
		visitedsq.X = 0;
		visitedsq.Y = 0;
		sucesspaths[0] = visitedsq;
		recursehorse(0,0,1);
	}


	private void recursehorse(int x, int y,int step) {
	
		
		//System.out.println(x + " : " + y);
		//System.out.println(step + " : "+ (rows*cols -1));
		if(step== (rows*cols)&&allsquaresVisited()){
			System.out.println("Paths_______________________________________");
			for(int i=0;i<sucesspaths.length;i++){
				System.out.println(sucesspaths[i].X + " : " +sucesspaths[i].Y );
			}
		}
		else{
			
			ArrayList<square> nexts = getNextSquare(x,y);
			for(int i=0;i<nexts.size();i++){	
				visitedsquares[nexts.get(i).X][nexts.get(i).Y] = true;
				square visitedsq = new square();
				visitedsq.X = nexts.get(i).X;
				visitedsq.Y = nexts.get(i).Y;
				sucesspaths[step] = visitedsq;
				recursehorse(nexts.get(i).X, nexts.get(i).Y, step+1);
				visitedsquares[nexts.get(i).X][nexts.get(i).Y] = false;
			}
			
		}
		
	}
	
	private boolean allsquaresVisited() {
		
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				if(visitedsquares[i][j] == false)
					return false;		
		return true;
	}


	private ArrayList<square> getNextSquare(int x,int y){
		
		ArrayList<square> possiblesquares = new ArrayList<HorseTour.square>();
		if( (x-2)>=0 && (x-2)<rows && (y-1)>=0 && (y-1)<cols &&visitedsquares[x-2][y-1]==false ){
			square s = new square();
			s.X = x-2;
			s.Y = y-1;
			possiblesquares.add(s);
		}
		if( (x-2)>=0 && (x-2)<rows && (y+1)>=0 && (y+1)<cols &&visitedsquares[x-2][y+1]==false ){
			square s = new square();
			s.X = x-2;
			s.Y = y+1;
			possiblesquares.add(s);
		}		
		if( (x-1)>=0 && (x-1)<rows && (y-2)>=0 && (y-2)<cols &&visitedsquares[x-1][y-2]==false){
			square s = new square();
			s.X = x-1;
			s.Y = y-2;
			possiblesquares.add(s);
		}
		if( (x-1)>=0 && (x-1)<rows && (y+2)>=0 && (y+2)<cols &&visitedsquares[x-1][y+2]==false){
			square s = new square();
			s.X = x-1;
			s.Y = y+2;
			possiblesquares.add(s);
		}
		if( (x+1)>=0 && (x+1)<rows && (y-2)>=0 && (y-2)<cols&&visitedsquares[x+1][y-2]==false ){
			square s = new square();
			s.X = x+1;
			s.Y = y-2;
			possiblesquares.add(s);
		}
		if( (x+1)>=0 && (x+1)<rows && (y+2)>=0 && (y+2)<cols&&visitedsquares[x+1][y+2]==false ){
			square s = new square();
			s.X = x+1;
			s.Y = y+2;
			possiblesquares.add(s);
		}
		if( (x+2)>=0 && (x+2)<rows && (y-1)>=0 && (y-1)<cols&&visitedsquares[x+2][y-1]==false ){
			square s = new square();
			s.X = x+2;
			s.Y = y-1;
			possiblesquares.add(s);
		}
		if( (x+2)>=0 && (x+2)<rows && (y+1)>=0 && (y+1)<cols&&visitedsquares[x+2][y+1]==false ){
			square s = new square();
			s.X = x+2;
			s.Y = y+1;
			possiblesquares.add(s);
		}		
		return possiblesquares;
	}
	
	public class square {
		public int X;
		public int Y;
	}
	
	
	public static void main(String args[]){
		
		HorseTour h = new HorseTour();
		h.findhorsepaths();
		
	}
	
}
