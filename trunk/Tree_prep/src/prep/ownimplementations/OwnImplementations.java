package prep.ownimplementations;

public class OwnImplementations {

	
	public static void main(String[] args) {
		
		char[] word = {'h','e','l','l','o'};
		stripString(word);
		System.out.println("NEW PALINDROME");

		System.out.println(isnewPalindrome("  a b  b  a"));
		
		atoi("1998");
		atoi("0000000");
		atoi("123456");
		atoi("123456a");
		itoa(1998);
		itoa(0000000);
		itoa(123456);
		findmincoins(86);
		findmincoins(50);
		findmincoins(2);
		findmincoins(1);
		findprime(100);
		System.out.println("3 is " +isPrime(3));
		System.out.println("9 is "+isPrime(9));
		System.out.println("29 is "+isPrime(29));
		System.out.println(sqrt(3));
		System.out.println(sqrt(9));
		System.out.println(sqrt(16));
		System.out.println("Word is "+ isPalindrome("word"));
		System.out.println("Liril is "+isPalindrome("liril"));
		System.out.println("pikillikip is "+ isPalindrome("pikillikip"));
		System.out.println("lllllllllll is "+ isPalindrome("lllllllllll"));
		System.out.println("198891 is "+ isPalindrome(198891));
		System.out.println("8888 is "+isPalindrome(8888));
		System.out.println("124521 is "+isPalindrome(124521));
		
		System.out.println("371 is Amstrong"+isAmstrong(371));
		System.out.println("241 is Amstrong"+isAmstrong(241));
		
		System.out.println("16 is power of 2 " + ispowerof2(16));
		System.out.println("18 is power of 2 " + ispowerof2(18));
		
		System.out.println("Upper value of 1234asdfTRUNTINGO!@#$%^  -- is ---"+toUpper("1234asdfTRUNTINGO!@#$%^"));
		System.out.println("Lower value of 1234asdfTRUNTINGO!@#$%^  -- is ---"+toLower("1234asdfTRUNTINGO!@#$%^"));
		
		
		System.out.println("hello".compareTo("hellow"));
		System.out.println("hellow".compareTo("hello"));		
	}
	
	
	public static void stripString(char[] word){
		
		word[3] = '\0';
		
		System.out.println(word);
	}
	
	public static int atoi (String str){
		int result = 0;
		for(int i=0; i<str.length();i++){		
			int c = str.charAt(i);			
			int num = c- 48;			
			if(num>10){
				System.out.println("EXECPTION");
				return 0;				
			}
			else{				
				result = result * 10 + num;
				System.out.println();
			}			
		}		
		System.out.println("Integer value is" + result);
		return result;
	}
	
	private static String itoa(int num){
		
		StringBuilder str = new StringBuilder();
		int rem = 0;
		while(num>0){			
			rem = num%10;			
			char c = (char) (48 + rem);			
			str.append(c);			
			num = num/10;			
		}
		
		
		String result = str.reverse().toString();
		System.out.println("String value is" + result);
		return "";
	}
	
	private static String toUpper(String str){
		StringBuilder rev = new StringBuilder();
		for(int i=0; i<str.length();i++){		
			int c = str.charAt(i);			
						
			if(c >= 65 && c<= 90){
					char temp = (char) c;
					rev.append(temp);			
			}
			else if(c>=97 && c<=122){
				c = c -32;
				char temp = (char) c;
				rev.append(temp);				
			}			
			else {
				char temp = (char) c;
				rev.append(temp);
			}
		}
		String result = rev.toString();
		System.out.println(result);
		return result;
	}
	
	private static String toLower(String str){
		StringBuilder rev = new StringBuilder();
		for(int i=0; i<str.length();i++){		
			int c = str.charAt(i);			
						
			if(c >= 65 && c<= 90){
				c = c +32;
				char temp = (char) c;
				rev.append(temp);
								
			}
			else if(c>=97 && c<=122){
				char temp = (char) c;
				rev.append(temp);				
			}			
			else {
				char temp = (char) c;
				rev.append(temp);
			}
		}
		String result = rev.toString();
		System.out.println(result);
		return result;
	}

	private static int pow(int i, int i2) {
		int result =1;
		for(int k = i2 ; k > 0;k--){
			result = result * i;			
		}
		return result;
	}
	
	
	private static boolean strMatch(String a, String b){
		return false;
	}
	private static String reverse(String s){
		return "";
	}
	
	private static String reversewords(String s){
		return "";
	}
	
	//fibonacci or not (5*N*N + 4) or (5*N*N - 4) is a perfect square
	
	private static void findmincoins(int num){
		
		int val = num;
		
		int[] coins = {0,0,0,0};
		
		while(num!=0){			
			if(num>=25){				
				num = num-25;
				coins[3] = coins[3] +1;
				continue;
			}
			if(num>=10){
				num = num -10;
				coins[2] = coins[2] +1;
				continue;
			}
			if(num>=5){
				num = num -5;
				coins[1] = coins[1] +1;
				continue;
			}
			if(num>=1){				
				num = num -1;
				coins[0] = coins[0] +1;
				continue;
			}			
		}
		System.out.println("_______________________________________");
		System.out.println("NUMBER :" + val);
		System.out.println("QUARTERS :" + coins[3]+" *25 ="+coins[3] *25);
		System.out.println("DIME  :" + coins[2]+" *10 ="+coins[2] *10);
		System.out.println("NICKEL :" + coins[1]+" *5 ="+coins[1] *5);
		System.out.println("PENNY :" + coins[0]+" *1 ="+coins[0] *1);		
	}
	
	
	private static void findprime(int upperlimit){
		
		boolean[] arr = new boolean[upperlimit+1];
	
		for(int i=1;i<=upperlimit;i++)
			arr[i] = true;
		
		for(int i=2;i<=upperlimit;i++){
			
			if(arr[i]==true){				
				for(int j=i+i;j<=upperlimit;j=j+i){
					arr[j] = false;
				}
			}
		}		
		System.out.println("___________PRIME____________________________");
		for(int i=1;i<=upperlimit;i++)
			if(arr[i] == true)
				System.out.println(i);		
	}
	
	
	private static boolean isPrime(int num){
		for(int i=2;i<num/2;i++){			
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	static double sqrt(double x) {
		   return test(x, 1);
	}
	
	static double test(double x, double g) {
		   if (closeEnough(x/g, g))
		      return g;
		   else
		      return test(x, betterGuess(x, g));
	}
	
	static boolean closeEnough(double a, double b) {
		   return (Math.abs(a - b) <= .000001);
	}
	
	static double betterGuess(double x, double g) {
		   return ((g + x/g) / 2);
	}
	
	
	static boolean isPalindrome(String word){
		
		int i=0;
		int j=word.length()-1;
		while(i<=j){
			
			if(word.charAt(i)!=word.charAt(j))
				return false;
			
			i++;
			j--;
		}
		return true;
	}
	
	static boolean isnewPalindrome(String word){
		
		int i=0;
		int j=word.length()-1;
		while(true){
			
			while(word.charAt(i)== ' '){
				i++;
			}
			
			while(word.charAt(j)== ' '){
				j--;
			}
			
			if(i>j)
				break;
			
			if(word.charAt(i)!=word.charAt(j))
				return false;
			
			i++;
			j--;
		}
		return true;
	}
	
	static boolean isPalindrome(int num){
		int val = num;
		int temp = 0;
		int dig = 0;
		while(num!=0){			
			dig = num % 10;
			temp = temp *10 + dig;
			num = num / 10;			
		}		
		if(temp==val)
			return true;
		else
			return false;
	}
	
	static boolean isAmstrong(int num){
		
		int val = num;
		int sum = 0;
		int dig = 0;
		while(num!=0){			
			dig = num % 10;
			sum = sum + dig * dig * dig;
			num = num / 10;			
		}	
		
		if(sum ==val)
			return true;
		else 
			return false;
	}
	
	static boolean ispowerof2(int num){		
		if((num & (num-1))==0)
			return true;
		return false;
	}
	
	public static void fib(int n) {
		int a=0,b=1;

	    for (int i=0;i<n;i++){
	      System.out.println(a);
	      a=a+b;
	      b=a-b;
	    }
	}
	
	public static int factorial( int p )
	  {
	    if ( p <= 0 )  
	     return 1;
	    else    
	     return ( p * factorial ( p - 1 ) );
	  }

	int gcd(int a, int b) {
		int temp;
		while (b != 0) { //not sure
			temp = a % b;
			a = b;
			b = temp;
		}
		return (a);
	}

	int gcd_recurse(int a, int b) {
		int temp;
		temp = a % b;
		if (temp == 0) {
			return (b);
		} else {
			return (gcd_recurse(b, temp));
		}

	}
	// Recursive algorithm int gcd_recurse(int a, int b) { int temp; temp = a % b; if (temp == 0) { return(b); } else { return(gcd_recurse(b, temp)); } }
	//permuations of a string iterative way
	//longest palindrome in a given array
	//23) Write function to compute Nth Fibonacci number? Both iterative and recursive?	
	//35) You need to write a function to climb n steps you can climb either 1 step at a time or 2 steps a time, write a function to return number of ways to climb a ladder with n step.
    ///Reverse words in a string (words are separated by one or more spaces). Now do it in-place. By far the most popular string question!	
	//Given two strings A and B, how would you find out if the characters in B were a subset of the characters in A?
	//How to fast multiply a number by 7?
	//Try (num<<3 - num)
	//Write code to remove duplicates in a sorted array
}
