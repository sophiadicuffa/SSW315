import java.util.Arrays;

public class ImageHelper {

	static boolean validMatrix(int[][] matrix) {
		boolean valid = false;
		int numRows = matrix.length;
		int numColumns = matrix[0].length;
		if(numRows == numColumns) {
			if (numRows >= 1 && numRows <= 100) 
				valid = true;
		}
		return valid;

	}
	static void flipVertical(int[][] matrix) {
		int minOne = matrix.length - 1;
		int temp = 0;
		for (int i = 0; i < minOne / 2; i++) {  // first half of rows
			for (int j = 0; j <=  minOne; j++) { // columns 
				temp = matrix[i][j];
				matrix[i][j] = matrix[minOne - i][j]; // switches first, first with last,first 
				matrix[minOne - i][j] = temp;
			}
		}

	}
	static void flipHorizontal(int[][] matrix) {
		int minOne = matrix.length - 1; //getting actual values
		int temp = 0;
		for (int i = 0; i <= minOne; i++) {
			for (int j = 0; j <= minOne / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][minOne - j]; // switches first, first with last, first 
				matrix[i][minOne - j] = temp;
			}
		}
		System.out.println(Arrays.deepToString(matrix));

	}
	static void rotateClockwise(int[][] matrix) {
		for(int i =0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - j][i];
				matrix[matrix.length - 1-j][i] = matrix[matrix.length -1 - i][matrix.length - 1 - j];
				matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix [j][matrix.length - 1 - i];
				matrix[j][matrix.length - 1 - i] = temp;
			}
		}

	}
	static void rotateCounterClockwise(int[][] matrix) {
		for(int i =0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][matrix.length - 1 - i]; // first, first to 
				matrix[j][matrix.length - 1-i] = matrix[matrix.length -1 - i][matrix.length - 1 - j];
				matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix [matrix.length - 1-j][i];
				matrix[matrix.length - 1 - j][i] = temp;
			}
		}

	}

	public static void main (String[] args) {
		int [][] test = {{1,2,3},{4,5,6},{7,8,9}}; 
		rotateClockwise(test);
	}

}
