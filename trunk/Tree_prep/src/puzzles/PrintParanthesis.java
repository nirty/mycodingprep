package puzzles;

public class PrintParanthesis {

	public static void printpranthesis(int num){		
		paran(num,num,"");		
	}
	public static void paran(int leftcount,int rightcount, String paran){
		
		if(rightcount==0){
			System.out.println("_____________________________"+paran);
			return;
		}		
		
		if(leftcount>0){
			System.out.println("1:   "+paran);
			paran(leftcount-1,rightcount,paran+"(");		
			
			if(leftcount<rightcount){
				System.out.println("2:   "+ paran);	
				paran(leftcount,rightcount-1,paran+")");					
			}
		}
		else{
			System.out.println("3:   "+ paran);
			paran(leftcount,rightcount-1,paran+")");
		}
	}
	
	public static void main(String args[]){
		printpranthesis(3);
	}
}
