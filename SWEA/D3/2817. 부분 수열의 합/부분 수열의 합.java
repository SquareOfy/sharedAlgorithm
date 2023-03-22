import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] seq;
	static int S;
	static int result = 0;
	static boolean[] flag;
	static int[] subseq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			// 수열 길이 및 목표 합 입력받기
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			seq = new int[N + 1];
			flag = new boolean[N + 1];
            result =0;
			st = new StringTokenizer(br.readLine());
			// 수열 입력 받기
			for (int i = 1; i <= N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				subseq = new int[i + 1];
				findSubseq(1, i, 1);
			}

			System.out.println("#"+t+" " + result);
		}

	}

	public static void findSubseq(int cnt, int len, int idx) {

		if (cnt == len + 1) {
			int sum = 0;
			idx = 1;
			for (int j = 1; j <= len; j++) {
				sum += subseq[j];
			}
			if (sum == S) {
				result++;

			}
			return;
		}

		for (int j = idx; j <= N; j++) {
			if (!flag[j]) {
				subseq[cnt] = seq[j];
				flag[j] = true;
				idx = j;
				findSubseq(cnt + 1, len, idx + 1);
				flag[j] = false;
			} else
				return;
		}
	}

}
