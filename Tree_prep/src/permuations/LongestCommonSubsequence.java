package permuations;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LongestCommonSubsequence {
	
    static String sequences [];
    static String s1, s2;
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner input = new Scanner(new File("longest.in"));
        PrintWriter output = new PrintWriter(new File("longest.out"));
        int index;
        
        while (input.hasNext()) {
            s1 = input.nextLine();
            s2 = input.nextLine();

            String temp = s1;
            if (temp.length() < s2.length()) {
                s1 = s2;
                s2 = temp;
            }
            sequences = new String [s2.length()];
            for (int counter = 0; counter < sequences.length; counter++) 
                sequences[counter] = "";
            
            index = findSequence();
            output.println(sequences[index].length() + " " + sequences[index]);
            
        }
        
        output.close();
    }
    
    public static int findSequence() {
        int temp = 0;
        int biggestSequence = 0;
        for (int counter = 0; counter < s2.length(); counter++) {
            if (s1.indexOf(s2.charAt(counter)) != -1) {
               for (int counter2 = counter; counter2 < s2.length(); counter2++) {
                    if (s1.indexOf(s2.charAt(counter2), temp) != -1) {
                        temp = s1.indexOf(s2.charAt(counter2), temp);
                        sequences[counter] = sequences[counter] + s1.charAt(temp);
                //                s1.indexOf(s2.charAt(counter), temp);
                    }
                }
            }
            temp = 0;
            if (sequences[counter].length() > sequences[biggestSequence].length())
                biggestSequence = counter;
        }
        return biggestSequence;
    }	
}

/**
nematode_knowledge
empty_bottle
empty_bottle
nematode_knowledge
abcd
abcd
1abc2def3
4abc5def6
abcdefgh
azbxcydwe
1a2b3c4d
aa1bb2cc3dd
abcdefghijklmnopqrstuvwxyz
a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6
aaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbb
aaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaacccccaaaaaccccc
*/


/**
 * 
 * 7 emt_ole
7 emt_ole
4 abcd
6 abcdef
5 abcde
4 123d
26 abcdefghijklmnopqrstuvwxyz
240 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 */
