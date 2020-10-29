import java.util.Scanner;

public class Rotation {

	public static void rotate(int[][] input, int k) {
		
		// transpose the given matrix
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				int temp = input[i][j];
				input[i][j] = input[j][i];
				input[j][i] = temp;
			}
		}

		// change columns
		for (int i = 0; i < input.length; i++) {
			int lIndex = 0;
			int rIndex = input[i].length - 1;

			while (lIndex < rIndex) {

				int temp = input[i][lIndex];
				input[i][lIndex] = input[i][rIndex];
				input[i][rIndex] = temp;
				lIndex++;
				rIndex--;
			}
		}
		
		k--;
		if(k==0) {
			displayMatrix(input);
		} else {
			rotate(input,k);
		}
	}

	private static void displayMatrix(int[][] input) {
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input.length;j++) {
				System.out.println(input[i][j]);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[][] input = new int[n][n];

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				input[i][j] = scan.nextInt();
			}
		}
		if(k%4 != 0) {
			rotate(input, k%4);
		} else {
			displayMatrix(input);
		}
		scan.close();
	}

}
