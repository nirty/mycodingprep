package prep.ownimplementations;

import java.util.ArrayList;
import java.util.Collections;
public class LongestIncreasingSubsequence { //ERRORS _______________ NOT WORKING

	public static ArrayList<Integer> find_list(ArrayList<Integer> A){
		
		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> p = new ArrayList<Integer>(A.size());
		 
		  int i, begin, end, mid;
		  
		  m.add(0);
		 
		  for (i = 1; i < A.size(); i++){
		    if (A.get(m.get(m.size()-1)) <= A.get(i)){
		    	
		    if(p.size()<i){
		    	p.add(m.get(m.size()-1));
		    }else{
		    	 p.set(i, m.get(m.size()-1));  // the order here is important
		    }
		      
		      m.add(i);
		      continue;
		    }
		     
		    for (begin = 0, end = m.size() -1; begin < end; ){
		      mid = (begin + end) / 2;
		      if (A.get(m.get(mid)) <= A.get(i)) 
		        begin = mid + 1;
		      else
		        end = mid;
		    }
		     
		    if (A.get(i) < A.get(m.get(begin))){
		      m.set(begin,i);
		      if (begin > 0){
		    	  
		    	  if(p.size()<i){
				    	p.add(m.get(begin - 1));
				    }else{
				    	 p.set(i,m.get(begin - 1));
				    }
		    	  
		    	  
		      }
		    }
		  }
		 
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  int pos ;
		 
		  pos = m.get(m.size()-1); 
		  for (i = m.size(); i > 0; i--){
		    result.add(A.get(pos));
		    pos =  p.get(pos);
		  }
		   
		  Collections.reverse(result);
		  return result; 
	}
	
	public static void main(String args[]){
		
		Integer a[] = { 7, 8, 9, 10, 1, 2, 3, 3, 3, 4, 6, 7, 5, 8}; //14
		 
		ArrayList<Integer> A = new ArrayList<Integer>();
		
		for(int i=0; i<a.length;i++)
			A.add(a[i]);
		
		
		ArrayList<Integer> result = find_list(A);
		
		for(int i=0; i<result.size();i++)
			System.out.print(result.get(i)+"\t");
			
		 
	}
}

 

