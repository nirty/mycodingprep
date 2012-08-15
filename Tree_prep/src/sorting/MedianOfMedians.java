package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MedianOfMedians {
        
        public static int select1(ArrayList<Integer> pList, int pK)
        {
            ArrayList<Integer> l_dup = pList;
            if (l_dup.size() <= 10 )
            {
                Collections.sort(l_dup);
                return l_dup.get(pK).intValue();
            }

            ArrayList<Integer> l_x = new ArrayList<Integer>();
            
            for( int i = 0 ; i < l_dup.size() ; i += 5 )
            {
                ArrayList<Integer> l_tmp = new ArrayList<Integer>();
                
                for( int q = i ; q < i+5 && q < l_dup.size() ; q++)
                {
                        l_tmp.add(l_dup.get(q));
                }
                
                if( i + 5 < l_dup.size() )
                        l_x.add(new Integer(select1(l_tmp,3)));//get median of this group
                else
                        l_x.add(new Integer(select1(l_tmp,(l_dup.size() - i)/2)));//get median of this group
            }
                
            int l_middle = select1(l_x, l_x.size()/2); // median of medians
                    
            ArrayList<Integer> l_lower, l_higher, l_exact;
            
            l_lower = new ArrayList<Integer>();
            l_higher = new ArrayList<Integer>();
            l_exact = new ArrayList<Integer>();
            
            
            // Can call Quick Select based on this median. 
            // This is other way of doing Quick Select
            for( int i = 0 ; i < l_dup.size(); i++ )
            {
                if( l_dup.get(i) < l_middle )
                        l_lower.add(l_dup.get(i));
                else if( l_dup.get(i) > l_middle )
                        l_higher.add(l_dup.get(i));
                else
                        l_exact.add(l_dup.get(i));
            }
            
            // Do recursive call. To find out the Kth Largest Value.
            if (pK < l_lower.size())
            {
                return select1(l_lower,pK);
            }
            else if (pK > l_lower.size() + l_exact.size() )
            {           
                return select1(l_higher, pK - l_lower.size() - l_exact.size());
            }
            else return l_exact.get(0);  //returns the Kth Largest Value.
        }
       
        
        public static void print(ArrayList<Integer> pist)
        {                
                for( int i = 0 ; i < pist.size() ; i++ )
                {
                      System.out.print(pist.get(i) + "  "); 
                }
                System.out.println();
        }
        
        public static void main(String args[])
        {
               
                       ArrayList<Integer> list = new ArrayList<Integer>();
                       list.add(9);
                       list.add(28);
                       list.add(1);
                       list.add(12);
                       list.add(5);
                       list.add(26);
                       list.add(7);
                       list.add(14);
                       list.add(3);
                       list.add(7);
                       list.add(2);
                       
                       	System.out.println("Before Median of Medians");
                        print(list); 
                        System.out.println("-----------------------");
                        int pos = 0; 
                        System.out.println(" REsult at: "+ pos +" is " + select1(list, pos));
                        System.out.println("-----------------------");
                        System.out.println("After Median of Medians");
                        print(list);
                        System.out.println("-----------------------");
                        System.out.println("SORTED");
                        Collections.sort(list);
                        print(list);                        
                        System.out.println("-----------------------");
                       
        }
}
 
