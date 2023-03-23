import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

		static int[][] map;
		static int N;
		static int cnt;

		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				N = Integer.parseInt(br.readLine());
				map = new int[N][N];
				cnt = 0;
				queen(0, 0);
				System.out.println(cnt);

			}

		

		public static void queen(int r, int c) {
			if(N==1) {
				cnt =1;
				return;
			}
			if(r==N || c==N) {
				return;
			}
			// 마지막 열을 봤는데 queen을 놓을 수 없으면 해당 행 보는 함수 종료.

			
			
			if (c == N - 1 && map[r][c]!=1)
				return;
			for (int i = 0; i < N; i++) {
				if (map[r][i]!=0) continue;

				//가로세로 모든대각 체킹
				check(r, i, 1); // check
	            
			    // 마지막 행을 보는데 해당 자리에 놓을 수 있으면 cnt ++
				if (r == N - 1 && map[r][i]==1) {
					cnt++;}
				// 다음 행 놓을 자리 보러 가기.
				queen(r + 1, c);
				// 다음행 자리 보고 나왔으면 지나왔던 길 uncheck
				check(r, i, -1); // uncheck

			}
			

		}

		public static void check(int r, int c , int ch) {
			map[r][c] += ch;
			for (int i = 0; i < N; i++) {
				if(i!=c) map[r][i] += ch; // 가로 체크
				if(i!=r) map[i][c] += ch; // 세로 체크
			}
				for (int k = 1; k < N; k++) {
					if ((r + k) < N && (c + k) < N)
						map[r + k][c + k] += ch; // 대각 체크
					if ((r + k) < N && (c - k) >= 0)
						map[r + k][c - k] += ch;
					if ((r - k) >= 0 && (c - k) >= 0)
						map[r - k][c - k] += ch; // 대각 체크
					if ((r - k) >= 0 && (c + k) < N)
						map[r - k][c + k] += ch;
				
			}

		}
	

}
