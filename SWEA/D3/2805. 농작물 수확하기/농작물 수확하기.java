import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();

				for (int j = Math.abs((i - N / 2)); j < N - Math.abs(i - N / 2); j++) {
					sum += str.charAt(j)-'0';
				}

			}
			
			System.out.printf("#%d %d \n", t, sum);
		}

	}

}