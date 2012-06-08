package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MedianOfMedians {
        public static Random g_Generator = new Random();
        
        public static int select(ArrayList<Integer> pList, int pK)
        {
                ArrayList<Integer> l_dup = new ArrayList<Integer>(pList);
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
                        l_x.add(new Integer(select(l_tmp,3)));
                else
                        l_x.add(new Integer(select(l_tmp,(l_dup.size() - i)/2)));
            }
                
            int l_middle = select(l_x, l_x.size()/2);
                    
            ArrayList<Integer> l_lower, l_higher, l_exact;
            
            l_lower = new ArrayList<Integer>();
            l_higher = new ArrayList<Integer>();
            l_exact = new ArrayList<Integer>();
            
            for( int i = 0 ; i < l_dup.size(); i++ )
            {
                if( l_dup.get(i) < l_middle )
                        l_lower.add(l_dup.get(i));
                else if( l_dup.get(i) > l_middle )
                        l_higher.add(l_dup.get(i));
                else
                        l_exact.add(l_dup.get(i));
            }
            
            if (pK < l_lower.size())
            {
                return select(l_lower,pK);
            }
            else if (pK > l_lower.size() + l_exact.size() )
            {           
                return select(l_higher, pK - l_lower.size() - l_exact.size());
            }
            else return l_exact.get(0);
        }
        
        public static void printList(ArrayList<Integer> pList)
        {
                System.out.print("Elements: ");
                
                int l_mean = 0;
                for( int i = 0 ; i < pList.size() ; i++ )
                {
                        if( i == pList.size() / 2 )
                                System.out.print(" | ");
                        System.out.print(pList.get(i) + ", ");
                        if( i == pList.size() / 2 )
                                System.out.print(" | ");
                        l_mean += pList.get(i);
                }
                
                l_mean /= pList.size();
                
                System.out.println(" - Mean: " + l_mean);
        }
        public static void main(String args[])
        {
                for( int i = 0 ; i < 100 ; i++ )
                {
                        ArrayList<Integer> l_list = new ArrayList<Integer>(20);

                        System.out.println("-----------------------");
                        for( int q = 0 ; q < 50 ; q++ )
                        {
                                l_list.add(new Integer(g_Generator.nextInt(1000)));
                        }
                        
                        printList(l_list);              
                        
                        System.out.println("Median: " + select(l_list, l_list.size()/2));       
                        
                        Collections.sort(l_list);
                        printList(l_list);
                        
                        System.out.println("-----------------------");
                }               
        }
}
 
