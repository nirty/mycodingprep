package permuations;

public class Permutations {

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
        	System.out.println("Extra prints :"+prefix);
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
    }
}
