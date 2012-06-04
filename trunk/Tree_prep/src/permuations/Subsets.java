package permuations;

public class Subsets {
	
	  //not with repetition
	 private static void findSubsets(char array[])
	    {
	      int numOfSubsets = 1 << array.length; 

	      for(int i = 0; i < numOfSubsets; i++)
	     {
	        int pos = array.length - 1;
	       int bitmask = i;

	       System.out.print("{");
	       while(bitmask > 0)
	       {
	        if((bitmask & 1) == 1)
	         System.out.print(array[pos]+",");
	        bitmask >>= 1;
	        pos--;
	       }
	       System.out.print("}");
	       System.out.println();
	     }
	    }

	static void printPowerSet(char[] set)
	 {
	     /*set_size of power set of a set with set_size
	       n is (2**n -1)*/
	     Double pow_set_size = Math.pow(2, new Double(set.length));
	     int counter, j;
	  
	     /*Run from counter 000..0 to 111..1*/
	     for(counter = 0; counter < pow_set_size; counter++)
	     {
	       for(j = 0; j < set.length; j++)
	        {
	           /* Check if jth bit in the counter is set
	              If set then pront jth element from set */
	    	   
	    	   // NOT WORKING __________________________________________________________________Have to change
	    	   //http://www.geeksforgeeks.org/archives/588
	           if( (counter & (1<<j)) != 1)
	             System.out.println(set);
	        }
	        System.out.println();
	     }
	 }
	
	// ITERATIVE IN CHAR ARRAY ?????????????????????????????????????????????????????????????????????????????????
	 
	 private static void subsets (String s)
	 {
	        subsetsAux(s, "", true);
	 }
	    
	 private static void subsetsAux(String remaining, String candidate, boolean print)
	  {
	        if (print)
	        {
	            System.out.println(candidate);
	        }
	        if (!remaining.equals(""))
	        {
	            subsetsAux(remaining.substring(1), candidate + remaining.charAt(0), true);
	            subsetsAux(remaining.substring(1), candidate, false);
	        }
	}
	
	 public static void main(String[] args) {
	 System.out.println("____________________ALL subsets in a array bit manipulation");      
     char[] set = {'h','e','l','l','o'};//http://codesam.blogspot.com/2011/03/find-all-subsets-of-given-set.html       
     findSubsets(set);
     System.out.println("---------------------------");   
     
     System.out.println("____________________ALL subsets in a array bit manipulation & power set");     
     printPowerSet(set);
     System.out.println("---------------------------"); 
     
     
     String test_str = "hello";
     System.out.println("_____________________Subsets of " + test_str);
     subsets(test_str);
     System.out.println("----------------------------");
     
	 }
}
