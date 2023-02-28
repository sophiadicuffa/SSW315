import java.util.Scanner; 
public class TaxCalculator {

	static double computeTax (int status, double income) {
		double tax = 0;
		if (status == 0) { // single filers
			if (income <= 10275)
				tax = income * 0.10;
			else if (income <= 41775)
				tax = 10275 * 0.10 + (income - 10275) * 0.12;
			else if (income <= 89075)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(income - 41775) * 0.22;
			else if (income <= 170050)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (income - 89075) * 0.24;
			else if (income <= 215950)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (170050 - 89075) * 0.24 +
				(income - 170050) * 0.32;
			else if (income <= 539900)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (170050 - 89075) * 0.24 +
				(income - 170050) * 0.32 + (income - 215950) * 0.35;
			else
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (170050 - 89075) * 0.24 +
				(215950 - 170050) * 0.32 + (539900 - 215950) * 0.35 + (income - 539900) * .37;
		}
		else if (status == 1) { // married file jointly
			if (income <= 20550)
				tax = income * 0.10;
			else if (income <= 83550)
				tax = 20550 * 0.10 + (income - 20550) * 0.12;
			else if (income <= 178150)
				tax = 20550 * 0.10 + (83550 - 20550) * 0.12 +
				(income - 83550) * 0.22;
			else if (income <= 340100)
				tax = 20550 * 0.10 + (83550 - 20550) * 0.12 +
				(178150 - 83550) * 0.22 + (income - 178150) * 0.24;
			else if (income <= 431900)
				tax = 20550 * 0.10 + (83550 - 20550) * 0.12 +
				(178150 - 83550) * 0.22 + (340100 - 178150) * 0.24 +
				(income - 340100) * 0.32;
			else if (income <= 647850)
				tax = 20550 * 0.10 + (83550 - 20550) * 0.12 +
				(178150 - 83550) * 0.22 + (340100 - 178150) * 0.24 +
				(income - 340100) * 0.32 + (income - 431900) * 0.35;
			else
				tax = 20550 * 0.10 + (83550 - 20550) * 0.12 +
				(178150 - 83550) * 0.22 + (340100 - 178150) * 0.24 +
				(431900 - 340100) * 0.32 + (647850 - 431900) * 0.35 + (income - 647850) * .37;

		}
		else if (status == 2) { //  married separately
			if (income <= 10275)
				tax = income * 0.10;
			else if (income <= 41775)
				tax = 10275 * 0.10 + (income - 10275) * 0.12;
			else if (income <= 89075)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(income - 41775) * 0.22;
			else if (income <= 170050)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (income - 89075) * 0.24;
			else if (income <= 215950)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (170050 - 89075) * 0.24 +
				(income - 170050) * 0.32;
			else if (income <= 323925)
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (170050 - 89075) * 0.24 +
				(income - 170050) * 0.32 + (income - 215950) * 0.35;
			else
				tax = 10275 * 0.10 + (41775 - 10275) * 0.12 +
				(89075 - 41775) * 0.22 + (170050 - 89075) * 0.24 +
				(215950 - 170050) * 0.32 + (323925 - 215950) * 0.35 + (income - 323925) * .37;

		}
		else if (status == 3) { //  head of household
			if (income <= 14650)
				tax = income * 0.10;
			else if (income <= 55900)
				tax = 14650 * 0.10 + (income - 14650) * 0.12;
			else if (income <= 89075)
				tax = 14650 * 0.10 + (55900 - 14650) * 0.12 +
				(income - 41775) * 0.22;
			else if (income <= 170050)
				tax = 14650 * 0.10 + (55900 - 14650) * 0.12 +
				(89075 - 55900) * 0.22 + (income - 89075) * 0.24;
			else if (income <= 215950)
				tax = 14650 * 0.10 + (55900 - 14650) * 0.12 +
				(89075 - 55900) * 0.22 + (170050 - 89075) * 0.24 +
				(income - 170050) * 0.32;
			else if (income <= 539900)
				tax = 14650 * 0.10 + (55900 - 14650) * 0.12 +
				(89075 - 55900) * 0.22 + (170050 - 89075) * 0.24 +
				(income - 170050) * 0.32 + (income - 215950) * 0.35;
			else
				tax = 14650 * 0.10 + (55900 - 14650) * 0.12 +
				(89075 - 55900) * 0.22 + (170050 - 89075) * 0.24 +
				(215950 - 170050) * 0.32 + (539900 - 215950) * 0.35 + (income - 539900) * .37;

		}
		return tax;
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); // Scanner to get values

		System.out.print(" Select a filing status: 0-single filer, 1-married jointly or " +
				"qualifying widow(er), 2-married separately, 3-head of " +
				"household: ");

		int status = input.nextInt();
		// check the validity of the status input and prompt the user until a valid input is given
		if (status < 0 || status > 3 ) {
			System.out.println("Error: invalid status");
			System.out.print(" Select a filing status: 0-single filer, 1-married jointly or " +
					"qualifying widow(er), 2-married separately, 3-head of " +
					"household: ");
			status = input.nextInt();
		}

		// Prompt the user to enter taxable income
		System.out.print("Enter the taxable income: ");
		double income = input.nextDouble();

		double tax = computeTax(status,income);

		System.out.println("Tax is " + (int)(tax * 100) / 100.0);
	}

}
