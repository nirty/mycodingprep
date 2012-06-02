package permuations;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class WordDistance {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("path.in"));
        PrintWriter out = new PrintWriter(new File("path.out"));
        String word1, word2;
        int[][] melchior;

        while (in.hasNext()) {
            word1 = in.nextLine();
            word2 = in.nextLine();
            out.print("Transformation of ");
            out.print(word1 + " to " + word2 + " in ");
            melchior = distance(word1, word2);
            int funVariable = melchior[melchior.length - 1][melchior[0].length - 1];
            out.print(funVariable);
            out.println(" steps: ");
            out.println();
            printStuff(melchior, melchior.length - 1, melchior[0].length - 1, word1, word2, out);
            out.println();
        }
        out.close();
    }

    private static String printStuff(int[][] map, int locX, int locY, String word1, String word2, PrintWriter out)
    {
        String modified;
        int difference;
        if(map[locX][locY]==0)
        {
            out.println("0. "+word1);
            return word1;
        }
        else if(locX!=0&&locY!=0&&map[locX-1][locY-1] == map[locX][locY] - 1)
        {
            modified = printStuff(map, locX-1, locY-1, word1, word2, out);
            difference = word1.length()-modified.length();
            modified = modified.substring(0, locX-1-difference).concat(Character.toString(word2.charAt(locY-1))).concat(modified.substring(locX-difference));
            out.println(map[locX][locY]+". "+modified);
            return modified;
        }
        else if(locX!=0&&map[locX-1][locY] == map[locX][locY] - 1)
        {
            modified = printStuff(map, locX-1, locY, word1, word2, out);
            difference = word1.length()-modified.length();
            modified = modified.substring(0, locX-1-difference).concat(modified.substring(locX-difference));
            out.println(map[locX][locY]+". "+modified);
            return modified;
        }
        else if(locY!=0&&map[locX][locY-1] == map[locX][locY] - 1)
        {
            modified = printStuff(map, locX, locY-1, word1, word2, out);
            difference = word1.length()-modified.length();
            modified = modified.substring(0, locX-difference).concat(Character.toString(word2.charAt(locY-1))).concat(modified.substring(locX-difference));
            out.println(map[locX][locY]+". "+modified);
            return modified;
        }
        else if(locX!=0&&locY!=0&&map[locX-1][locY-1] == map[locX][locY])
        {
            return printStuff(map, locX-1, locY-1, word1, word2, out);
        }
        else
        {
            return "something is seriously wrong.";
        }
    }

    private static int[][] distance(String word1, String word2) {
        int rows = word1.length() + 1;
        int cols = word2.length() + 1;
        int[][] distances = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    distances[i][j] = j;
                } else if (j == 0) {
                    distances[i][j] = i;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distances[i][j] = distances[i - 1][j - 1];
                } else {
                    if (distances[i - 1][j] + 1 < distances[i][j]) {
                        distances[i][j] = distances[i - 1][j] + 1;
                    }
                    if (distances[i - 1][j - 1] + 1 < distances[i][j]) {
                        distances[i][j] = distances[i - 1][j - 1] + 1;
                    }
                    if (distances[i][j - 1] + 1 < distances[i][j]) {
                        distances[i][j] = distances[i][j - 1] + 1;
                    }
                }
            }
        }
        return distances;
    }
}

/**
 * aaacccccbbb
aaadddddbbb
aaacccccbbb
aaacccbbb
aaacccbbb
aaacccccbbb
whaleshark
whaleshark
whlespaark
whaleshark
0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789
0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789
 */

/**
Transformation of aaacccccbbb to aaadddddbbb in 5 steps: 

0. aaacccccbbb
1. aaadccccbbb
2. aaaddcccbbb
3. aaadddccbbb
4. aaaddddcbbb
5. aaadddddbbb

Transformation of aaacccccbbb to aaacccbbb in 2 steps: 

0. aaacccccbbb
1. aaaccccbbb
2. aaacccbbb

Transformation of aaacccbbb to aaacccccbbb in 2 steps: 

0. aaacccbbb
1. aaaccccbbb
2. aaacccccbbb

Transformation of whaleshark to whaleshark in 0 steps: 

0. whaleshark

Transformation of whlespaark to whaleshark in 3 steps: 

0. whlespaark
1. whalespaark
2. whaleshaark
3. whaleshark

Transformation of 0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789 to 0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789 in 0 steps: 

0. 0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789
*/