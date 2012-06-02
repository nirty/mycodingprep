package permuations;

import java.util.ArrayList;
import java.util.HashMap;

public class T9Keypad {
	
	static HashMap<Character,ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
	
	public static void populateMap(){
		ArrayList<Character> one = new ArrayList<Character>();
		one.add('1');
		one.add('1');
		one.add('1');		
		map.put('1',one);
		ArrayList<Character> zero = new ArrayList<Character>();
		zero.add('0');
		zero.add('0');
		zero.add('0');		
		map.put('0',zero);
		ArrayList<Character> two = new ArrayList<Character>();
		two.add('a');
		two.add('b');
		two.add('c');		
		map.put('2',two);
		ArrayList<Character> three = new ArrayList<Character>();
		three.add('d');
		three.add('e');
		three.add('f');		
		map.put('3',three);
		ArrayList<Character> four = new ArrayList<Character>();
		four.add('g');
		four.add('h');
		four.add('i');		
		map.put('4',four);
		ArrayList<Character> five = new ArrayList<Character>();
		five.add('j');
		five.add('k');
		five.add('l');		
		map.put('5',five);
		ArrayList<Character> six = new ArrayList<Character>();
		six.add('m');
		six.add('n');
		six.add('o');		
		map.put('6',six);
		ArrayList<Character> seven = new ArrayList<Character>();
		seven.add('p');
		seven.add('r');
		seven.add('s');		
		map.put('7',seven);
		ArrayList<Character> eight = new ArrayList<Character>();
		eight.add('t');
		eight.add('u');
		eight.add('v');		
		map.put('8',eight);
		ArrayList<Character> nine = new ArrayList<Character>();
		nine.add('w');
		nine.add('x');
		nine.add('y');		
		map.put('9',nine);
	}
	
	public static char getchar(char key, int position){	
			return map.get(key).get(position-1);
	}
	
	
	public static void recursivet9(String Phonenum){
		char[] result = new char[Phonenum.length()];
		recurs(Phonenum,0, result);		
	}
	
	private static void recurs(String phone,int position,char[] result){
		
		if(position==phone.length()){
			printarr(result);
			return;
		}
		
		for(int i=1;i<=3;i++){
			result[position] = getchar(phone.charAt(position),i);
			recurs(phone,position+1,result);
			if(phone.charAt(position)== '0' || phone.charAt(position)== '1')
				return;
		}
	}
	
	private static void printarr(char[] result){
		for(int k=0;k<result.length;k++)
			System.out.print(result[k]);
		System.out.println();
	}
	public static void main(String args[]){
		populateMap();
		System.out.println("Recursive T9____________________________");
		recursivet9("4971927");
		System.out.println("Iterative T9____________________________");
		iterativet9("4971927");
	}

	private static void iterativet9(String Phonenum) {
		char[] result = new char[Phonenum.length()];
		
		//get all 1's of those numbers 
		for(int i=0;i<Phonenum.length();i++)
			result[i] = getchar(Phonenum.charAt(i),1);
		
		while(true){
			printarr(result);
			
			for(int i=Phonenum.length()-1;i >=-1 ;i--){
				
			if(i==-1)
				return;
			
			if( Phonenum.charAt(i) == '0' || Phonenum.charAt(i) == '1'  || getchar(Phonenum.charAt(i),3) == result[i]){
				result[i] = getchar(Phonenum.charAt(i),1);
			}
			else if(getchar(Phonenum.charAt(i),1) == result[i]){
				result[i] = getchar(Phonenum.charAt(i),2);
				break;
				
			}else if (getchar(Phonenum.charAt(i),2) == result[i]){
				result[i] = getchar(Phonenum.charAt(i),3);
				break;
			}
			
			}
		}
		
	}

}
