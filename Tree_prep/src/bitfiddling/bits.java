package bitfiddling;

public class bits {

	//swap nibbles
	//big endian little endian
	//checkif max bit is set
	//xor.. multiple by 2
	//count how many bits set in an integer
	//purpose of xor or and
	//reverse bits in an integer
	
	static int countbits_bk_method (int b)
	{
	
	 int count;

	 System.out.println("in loop");
	for (count = 0; b != 0; count++)
	  {
	  b &= b - 1; // this clears the LSB-most set bit
	  System.out.println(b);
	  }

	return (count);
	}
	
	static int bitCount (int value) {
		
		StringBuffer binary = new StringBuffer();
	    int count = 0;
	    while (value > 0) {           // until all bits are zero
	        if ((value & 1) == 1){    // check lower bit
	            count++;
	            binary.append('1');
	        }else{
	        	binary.append('0');
	        }
	        value >>>= 1;              // shift bits, removing lower bit
	    }
	    
	    System.out.println("Binary value of "+ value + " is : " + binary.reverse().toString());
	    return count;
	}
	
	
	public static void main(String args[]){
		
		int b = 255;
		/*
		 * This is to convert into unsigned int in Java. By default Java is Signed. . 
		 * cannot make it unsigned unless u operate on the bits directly
		 * long temp = 1;
		temp = temp<<7;
		System.out.println("Long after 31  :"+ temp);
		 temp = temp & 0xff;
		 System.out.println("temp after castrating"+ temp);*/
		
		
		System.out.println(" BK METHOD  : "+ countbits_bk_method(b));
		System.out.println("SHifting Method the int val : " + bitCount (b));
		
		
	}

}
