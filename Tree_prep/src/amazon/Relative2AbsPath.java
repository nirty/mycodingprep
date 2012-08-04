package amazon;

import java.util.Stack;

public class Relative2AbsPath {
	static Stack<String> wordstack = new Stack<String>();
	
	public static String convertPath(String relpath){
		
		
		
		
		if(relpath.indexOf("/") == 0)
			relpath = relpath.substring(1);
		
		if(relpath.lastIndexOf("/")==relpath.length()-1)
			relpath = relpath.substring(0,relpath.length()-1);
		
		
		String[] tokens = relpath.split("/");
		
		for(int i=0;i<tokens.length;i++)
			wordstack.push(tokens[i]);
		
		
				
					
		
		return recursepopping();
	}
	
	
	public static String recursepopping(){
		
		StringBuffer result = new StringBuffer();
		
		while(wordstack.size()>0){	
			String word = wordstack.pop();
			if(word.equals("..")){	
				
				String b4 = wordstack.peek();
				if(b4.equals("..")){
					//wordstack.pop();
					recursepopping();
				}
				else
					wordstack.pop();
			}else{		
				
				result.append( "/"+ word); 
				//wordstack.pop();
			}
		}
		
		
		String ans = result.toString();
		result = null;
		return ans;
	}
	
	public static void main(String args[]){
		
		
		
		//String relpath = "/windows/abs/../temp/new/../"; //windows/temp
		String relpath2 = "/windows/abs/temp/../../new/"; //windows/new
		
		//System.out.println(convertPath(relpath));
		System.out.println(convertPath(relpath2));
		
	}

}
