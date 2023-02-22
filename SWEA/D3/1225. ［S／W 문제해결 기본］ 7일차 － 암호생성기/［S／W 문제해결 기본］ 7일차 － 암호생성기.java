import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			String T = br.readLine();
			st = new StringTokenizer(br.readLine());
			int[] numbers = new int[8];
			int idx = 0;
			int n = 1;
			for (int i = 0; i < 8; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			while (numbers[idx]-n >0) {
				numbers[idx] = numbers[idx] - n;
				idx++;
				idx = idx % 8;
				n++;
				if(n==6) n=1;
			}
			numbers[idx] = 0;
			idx = (idx + 1) % 8;
			System.out.printf("#%d ", t);
			for (int i = idx; i < 8; i++) {
				System.out.print(numbers[i] + " ");
			}
			if (idx != 0) {
				for (int j = 0; j < idx; j++) {
					System.out.print(numbers[j] + " ");
				}
				
			}
			System.out.println();
		}
	}

}
