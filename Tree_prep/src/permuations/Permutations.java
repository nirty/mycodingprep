package permuations;

import java.util.HashSet;

public class Permutations {

	//http://www.bearcave.com/random_hacks/permute.html
    // print N! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++){            	
               perm1(prefix + s.charAt(i), s.substring(0, i)+s.substring(i+1, N));
            }
        }

    } 

    public  static void perm_k(String s) { perm_k("", s); }
    private static void perm_k(String prefix, String s) {
    	if(prefix.length()== 3)
        	System.out.println(prefix);
        int N = s.length();
        if (N == 0){
        	//System.out.println("Extra prints :"+prefix);
        }
        else {
            for (int i = 0; i < N; i++){   
            	if(prefix.length()+1<=3)
            		perm_k(prefix + s.charAt(i), s.substring(0, i)+s.substring(i+1, N));
            }
        }

    } 

    
    public static void comb2(String s) { comb2("", s); }
    private static void comb2(String prefix, String s) {
        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++)
            comb2(prefix + s.charAt(i), s.substring(i + 1));
    } 
    
    public static void comb_k(String s) { comb_k("", s); }
    private static void comb_k(String prefix, String s) {
    	if(prefix.length()==3)
    		System.out.println(prefix);
        for (int i = 0; i < s.length(); i++)
        	//if(prefix.length()+1<=2)
        		comb_k(prefix + s.charAt(i), s.substring(i + 1));
    }
    
    static HashSet<String> unique_combinations = new HashSet<String>();
    public static void comb_u(String s) { comb_u("", s); }
    private static void comb_u(String prefix, String s) {
        System.out.println(prefix);        
        for (int i = 0; i < s.length(); i++){ 
        	if(unique_combinations.contains(prefix + s.charAt(i))){}
        	else{
        	unique_combinations.add(prefix + s.charAt(i));
        	comb_u(prefix + s.charAt(i), s.substring(i + 1));
        	}
        }
    }
    
    
    public static void swap(char[] set, int first, int second) //java doesn't allow the same pass by reference like C++
	{
	        char ch = set[second]; //so we pass the char array and assign, since this will hold
	        set[second] = set[first]; //swap the values
	        set[first] = ch;
	}
	
    //backtracking permutations
	public static int permute(char[] set, int begin, int end)
	{
	        int i;
	        int range = end - begin;
	        if (range == 1) {
	                System.out.println(set); //print out each permutation
	        } else {
	                for(i=0; i<range; i++) {
	                        swap(set, begin, begin+i);		//initial swap
	                        permute(set, begin+1, end);		//recursion
	                        swap(set, begin, begin+i);       //swap back
	                }
	        }
	        return 0;
	}

	public  static void permfix(String s) { 
		
		boolean[] stoppos = new boolean[s.length()];		
		String processword = preprocessing (s,stoppos);
		permfix("", processword, s,stoppos ); 
		
	}
	
	private static String preprocessing (String word,boolean arr[]){
		
		StringBuffer resultword = new StringBuffer();
		for(int i=0;i<word.length();i++){
			
			if(word.charAt(i)>=97 && word.charAt(i)<=122){
				arr[i] = false;
				resultword.append(word.charAt(i));
			}
			else{
				arr[i] = true;
			}
		}
		return resultword.toString();
	}
    private static void permfix(String prefix, String s,String finalstr,boolean[] pos) {
        int N = s.length();
        if (N == 0) {      
        	for(int hj=0;hj<pos.length;hj++){        		
        		if(pos[hj] == true){        			
        			prefix = prefix.substring(0, hj)+finalstr.charAt(hj)+prefix.substring(hj);
        		}        		
        	}
        	System.out.println(prefix);
        }
        else {
            for (int i = 0; i < N; i++){            	
               permfix(prefix + s.charAt(i), s.substring(0, i)+s.substring(i+1, N),finalstr, pos);
            }
        }

    } 
	     
    public static void main(String[] args) {
       int N = 3;
       String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String elements = alphabet.substring(0, N);
       System.out.println("____________________ALL POSSIBLE PERMUATIONS");
       perm1(elements);
       System.out.println("-------------------------");
       System.out.println("____________________ALL POSSIBLE COMBINATIONS");
       comb2(elements);
       System.out.println("--------------------------");
       System.out.println("____________________ALL POSSIBLE PERMUATIONS of SIZE 3");
       perm_k(elements);
       System.out.println("--------------------------");
       System.out.println("____________________ALL POSSIBLE COMBINATIONS of SIZE 3");
       comb_k(elements);
       System.out.println("---------------------------");
       System.out.println("____________________ALL Unique Combinations");
       comb_u("hello");
       System.out.println("---------------------------");        
       System.out.println("_______________BACKTRACKING PERMUTE");
       char[] test = {'a','b','c','d'};
       permute(test, 0, 4);
       System.out.println("---------------------------");
       System.out.println("_______________Permutation with some elements ignored!! -- removing and then appending appropriate positions");
       permfix("a;cB:{}do()");
      
    }
}
