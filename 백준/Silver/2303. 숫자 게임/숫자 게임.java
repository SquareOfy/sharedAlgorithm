import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int result = 0;
		int[] sumN = new int[N];
		int sum = 0;
		int max = 0;
		int[][] card = new int[N][5];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				card[i][j] = sc.nextInt();
			}
		}

		for (int n = 0; n < N; n++) {
			sum = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					for (int k = j + 1; k < 5; k++) {
						sum = (card[n][i] + card[n][j] + card[n][k]) % 10;

						if (sum > sumN[n])
							sumN[n] = sum;
					}

				}
			}
		}

		for (int n = 1; n <= N; n++) {
			if (sumN[n - 1] >= max) {
				max = sumN[n - 1];
				result = n;
			}

		}

		System.out.println(result);

	}

}