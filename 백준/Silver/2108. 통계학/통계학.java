import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];

		double mean = 0;
		int mod = 0;
		int maxCnt = 0;

		for (int n = 0; n < N; n++) {
			map[n] = Integer.parseInt(br.readLine());
			mean += map[n];
		}
		int gap = 0;



		if (N == 1) {
			mod = map[0];

		} else {
			Arrays.sort(map);
			gap = map[N - 1] - map[0];

			int[] count = new int[gap + 1];
			for (int n = 0; n < N; n++) {
				count[map[n] - map[0]]++;
				maxCnt = Math.max(maxCnt, count[map[n] - map[0]]);
			}

			boolean flag = false;
			for (int n = 0; n <= gap; n++) {
				if ((flag || n == gap) && maxCnt == count[n]) {
					
					mod = n + map[0];
					
					break;
				} else if (!flag && maxCnt == count[n]) {
					mod = n+map[0];
					flag = true;
				
				}
		
			}

		}


		mean = Math.round((double)mean / N);
		sb.append(String.format("%.0f", mean)).append("\n");

		sb.append(map[N / 2]).append("\n").append(mod).append("\n");
		sb.append(gap);

		System.out.println(sb.toString());

	}

}
