

public class RomanNumber {

	private int number; //A private int data field that stores the value represented by this object.
	private String numeral; //A private String data field representing the value in Roman Numbers. 

	//Constructors that create a RomanNumber object for the Roman Number specified as a String or an int.

	public RomanNumber(int value) {
		this.number = value;
	}
	public RomanNumber(String numeral) {
		this.numeral = numeral;

	}

	public String getNumber(){	//A getNumber method that returns a String representing the Roman Number.
		String s_number = parseNumber(number);
		return s_number;
	}

	public int getValue() {		//A getValue method that returns an int representing the number.
		int val = parseValue(numeral);
		return val;
	}

	static int value(char r) // helper fn for parseNumber
	{
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}

	static int parseValue(String num){   //A static method parseValue(String num) that converts a String representing a Roman Number into an int.
		int res = 0;
		for (int i = 0; i < num.length(); i++) {
			int s1 = value(num.charAt(i));
			if (i + 1 < num.length()) {
				int s2 = value(num.charAt(i + 1));
				if (s1 >= s2) {
					res = res + s1;
				}
				else {
					res = res + s2 - s1;
					i++;
				}
			}
			else {
				res = res + s1;
			}
		}
		return res;
	}

	static String parseNumber(int num){   //A static method parseNumber(int num) that converts an int num into a String representing the Roman Number .
		String romanNumeral;
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
		String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
		StringBuilder roman = new StringBuilder();  
		for(int i=0;i<values.length;i++)   
		{  
			while(num >= values[i])   
			{  
				num = num - values[i];  
				roman.append(romanLetters[i]);  
			}  
		}  
		romanNumeral = roman.toString(); 
		return romanNumeral;
	}

	public boolean equals(String number) { ///Methods equals(String) and equals(int) that return true if the value in the object is equal to the specified value.
		return this.numeral.equals(number);
	}
	public boolean equals(int value) {
		return this.number == value;
	}

	public String add (String num){ //Methods add(String num), subtract(String num), multiply(String num), divide(String num),  that return a String representing the Roman Number after addition, subtraction, multiplication, integer division, respectively, of the object value with the num.
		String res = "";
		int numValue = parseValue(num);
		int endRes = numValue + this.getValue();
		if(endRes < 1) throw new IllegalArgumentException("Roman numerals must be positive.");
		res = parseNumber(endRes);
		return res;
	}

	public String subtract(String num) {
		String res = "";
		int numValue = parseValue(num);
		int endRes = numValue - this.getValue();
		if(endRes < 1) throw new IllegalArgumentException("Roman numerals must be positive.");
		res = parseNumber(endRes);
		return res;
	}
	public String multiply(String num) {
		String res = "";
		int numValue = parseValue(num);
		int endRes = numValue * this.getValue();
		if(endRes < 1) throw new IllegalArgumentException("Roman numerals must be positive.");
		res = parseNumber(endRes);
		return res;
	}
	public String divide(String num) {
		String res = "";
		int numValue = parseValue(num);
		int endRes = numValue / this.getValue();
		if(endRes < 1) throw new IllegalArgumentException("Roman numerals must be positive.");
		res = parseNumber(endRes);
		return res;
	}

	public static String calculate(String expression){//A static method calculate(String expression) that performs calculation of a String of two roman numbers separated with an operand, and returns a String representing the resulting Roman Number.

		String[] ary = expression.split(" ");
		int num1 = parseValue(ary[0]);
		int num2 = parseValue(ary[2]);

		if(ary[1].equals("+"))
			return parseNumber(num1 + num2);
		if(ary[1].equals("-"))
			return parseNumber(num1 - num2);
		if(ary[1].equals("*"))
			return parseNumber(num1 * num2);
		if(ary[1].equals("/"))
			return parseNumber(num1 / num2);
		return "operand character not readable.";
	}

	public String min(String num){//Methods min(String num) and max(String num) that return a string representing the maximum and minimum, respectively, of the value of the object and given num.
		int num1 = parseValue(num);
		int num2 = this.getValue();
		if (num1 > num2)
			return parseNumber(num2);
		else
			return parseNumber(num1);
	}

	public String max(String num) {
		int num1 = parseValue(num);
		int num2 = this.getValue();
		if (num1 < num2)
			return parseNumber(num2);
		else
			return parseNumber(num1);
	}

}


