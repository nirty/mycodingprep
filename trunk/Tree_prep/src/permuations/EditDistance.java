package permuations;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EditDistance
{
   public static void main (String [] args) throws FileNotFoundException
   {
       
	   		String word1, word2;
       
           word1 = "Hello";
           word2 = "Heklo";
           System.out.print("The edit distance between ");
           System.out.print(word1 + " and " + word2 + " is ");
           System.out.println(distance(word1, word2));
      
   }
   
   private static int distance (String word1, String word2)
   {
       int rows = word1.length() + 1;
       int cols = word2.length() + 1;
       int [][] distances = new int[rows][cols];
       
       for (int i = 0; i < rows; i++)
       {
           for (int j = 0; j < cols; j++)
           {
               if (i == 0)
               {
                   distances[i][j] = j;
               }
               else if (j == 0)
               {
                   distances[i][j] = i;
               }
               else
               {
                   distances[i][j] = Integer.MAX_VALUE;
               }
           }
       }
       
       printTable(distances, rows, cols);
       for (int i = 1; i < rows; i++)
       {
           for (int j = 1; j < cols; j++)
           {
               if (word1.charAt(i-1) == word2.charAt(j-1))
               {
                   distances[i][j] = distances[i-1][j-1];
               }
               else
               {
                   if (distances[i-1][j] + 1 < distances[i][j])
                   {
                       distances[i][j] = distances[i-1][j] + 1;
                   }
                   if (distances[i-1][j-1] + 1 < distances[i][j])
                   {
                       distances[i][j] = distances[i-1][j-1] + 1;
                   }
                   if (distances[i][j-1] + 1 < distances[i][j])
                   {
                       distances[i][j] = distances[i][j-1] + 1;
                   } 
                   
                   distances [i][j] =  Math.min(distances[i][j], Math.min(distances[i-1][j] +1 , Math.min(distances[i-1][j-1] + 1, distances[i][j-1] + 1)));
                   System.out.println("MAx calculation is :" + Math.min(distances[i][j], Math.min(distances[i-1][j] +1 , Math.min(distances[i-1][j-1] + 1, distances[i][j-1] + 1))) + "  : Normal caluclation is "+ distances[i][j]);
               }
           }
       }
       
       printTable(distances, rows, cols);
       
       return distances[rows - 1][cols - 1];
   }
   
   
   //can do the words that has to be changed ... 
   
   
   private static void printTable (int [][] table, int rows, int cols)
   {
       System.out.println();
       for (int i = 0; i < rows; i++)
       {
           for (int j = 0; j < cols; j++)
           {
               System.out.print(table[i][j] + " ");
           }
           System.out.println();
       }
   }

}
