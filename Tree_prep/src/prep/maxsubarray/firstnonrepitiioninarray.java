package prep.maxsubarray;

public class firstnonrepitiioninarray {

	
	static char getFirstNonRepetitiveChar(String str) {
		  int[] seen = new int[256];
		  // if seen[i] == 0 -> character wasn't seen
		  // if seen[i] == -1 -> character was seen more than once
		  // else seen[i] == the index that character was seen at

		for (int i=0; i<seen.length; i++) {			
			     seen[i] = 0;
		}

		for (int i=0; i<str.length(); i++) {			
		    int c = str.charAt(i);		    
		    //System.out.println(c +":"+ str.charAt(i) );
		    if (seen[c] == 0) { // hasn't been see yet
		      seen[c] = i+1; // save the index
		    } else if (seen[c] != -1) { // has been see once
		      seen[c] = -1;
		    } // has already been seen more than once
		 }
		  // find min in the list such that min != -1 or 0
		  int min = -1;
		  for (int i=0; i<seen.length; i++) {
			//  System.out.println(" VAlue at "+ i + "is" + seen[i]);
		    if (seen[i] != 0 && seen[i] != -1) {
		      // for readability sake
		      if (min == -1 || seen[i] < min) {		    	  
		        min = seen[i];
		      }
		    }
		  }
		  
		 return (min != -1) ? str.charAt(min-1) : null;
		}

	
	public static void main(String args[]){
		
		
		System.out.println(getFirstNonRepetitiveChar("hello"));
		System.out.println(getFirstNonRepetitiveChar("jkiokji"));
		
		
	}
}