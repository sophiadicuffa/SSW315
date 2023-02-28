
public class CardValidator {


	public static boolean isValid(long number) {
		boolean valid = false;
		
		String longnum = String.valueOf(number);
		
//		String[] longnum_array = longnum.split("");
//		System.out.println(Arrays.toString(longnum_array));
		
		int length = longnum.length();
		System.out.println(length);

		int nSum = 0;
		boolean isSecond = false;
	    for (int i = length - 1; i >= 0; i--)
	    {
	 
	        int d = longnum.charAt(i) - '0';
	 
	        if (isSecond == true) // Step 1
	            d = d * 2;
	 
	        // Step 2,3,4
	        nSum += d / 10;
	        nSum += d % 10;
	 
	        isSecond = !isSecond;
	    }
		if (nSum % 10 == 0) // Step 5
			valid = true;

		return valid;
	}


	public static void main(String[] args) {

		long longnum = 4388576018402626l;

		System.out.println(isValid(longnum));

	}

}
