
public class MyInteger {

	private int value;

	public MyInteger() {
		this(0);
	}
	
	public MyInteger(char[] value) {
		this(parseInt(value));
	}
	
	public MyInteger(String value) {
		this(parseInt(value));
	}

	public MyInteger(int newValue){ //A constructor that creates a MyInteger object with given val. If no value is provided a default of 0 is used.
		value = newValue;
	}

	public int getValue(){ // An int get() method that returns the value
		return value;
	}
	
	public boolean set(char[] value) {
		return set(parseInt(value));
	}

	public boolean set(String value) {
		return set(parseInt(value));
	}

	public boolean set(int val) { //A boolean set(int val) method that updates the value and returns true if successful or false if unsuccessful.
		boolean success = false;
		value = val;
		if(value == val)
			success = true;
		return success;
	}


	public boolean isEven(){ //Boolean methods isEven()
		return isEven(value);
	}

	public boolean isOdd(){ // is Odd()
		return isOdd(value);
	}

	public boolean isPrime(){ // isPrime()
		return isPrime(value);
	}

	public static boolean isEven(int value){ //Static boolean methods isEven(int val)
		if(value % 2 == 0)
			return true;
		return false;
	}

	public static boolean isOdd(int value){ //isOdd(int val)
		if(value % 2 != 0)
			return true;
		return false;
	}

	public static boolean isPrime(int value){ // isPrime(int val) 
		if(value<=1)
			return false;
		
		for(int i=2;i<=value/2;i++)
		{
			if((value%i)==0)
				return false;
		}
		return true;
	}

	public static boolean isEven(MyInteger myInteger){ //Static boolean methods isEven(MyInteger val)
		return MyInteger.isEven(myInteger.getValue());
	}

	public static boolean isOdd(MyInteger myInteger){ //isOdd(MyInteger val)
		return isOdd(myInteger.getValue());
	}

	public static boolean isPrime(MyInteger value) {
		return isPrime(value.getValue());
	}

	public boolean equals(int intValue){ //Boolean methods equals(int val)
		return value == intValue;
	}

	public boolean equals(MyInteger myInteger){ //equals(MyInteger val)
		return equals(myInteger.getValue());
	}

	public static int parseInt(char[] val) { //A static method int parseInt(char[] val) that converts a val array of numeric characters to an integer.
		int fullInt = 0;
		for(int i=0; i < val.length;i++) {
			fullInt = fullInt * 10 + val[i] - '0';
		}
		return fullInt;
	}

	public static int parseInt(String s){ //A static method int parseInt(String val) that converts a val string into an integer.
		return Integer.parseInt(s);
	}

}
