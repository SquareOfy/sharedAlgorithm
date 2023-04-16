import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] eggs;

	static int max;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			eggs[n][0] = Integer.parseInt(st.nextToken());
			eggs[n][1] = Integer.parseInt(st.nextToken());

		}
		breakEgg(0);
		System.out.println(max);
	}

	static void breakEgg(int n) {
		if (n == N) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				if (eggs[i][0] <= 0)
					cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		//이번에 들려는 계란이 안 깨져 있으면
		if (eggs[n][0] > 0) {
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (n != j && eggs[j][0] > 0) {
					
					eggs[j][0] -= eggs[n][1];
					eggs[n][0] -= eggs[j][1];
					flag = true;
					breakEgg(n + 1);

					eggs[j][0] += eggs[n][1];
					eggs[n][0] += eggs[j][1];

				}
				
				if(!flag) breakEgg(N);
			}
		//다음 계란이 이미 깨져있을 땐 그 옆 계란 집어들기
		} else {
			breakEgg(n + 1);
		}
	}
}