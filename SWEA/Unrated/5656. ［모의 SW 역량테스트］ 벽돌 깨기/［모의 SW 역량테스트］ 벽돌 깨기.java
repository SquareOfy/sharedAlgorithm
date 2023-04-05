import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int[] result;
	static int blockCnt;
	static int min;
	static int[][] tempMap;
	static boolean[][] visited ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 입력 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H + 2][W + 2]; //입력값 받을 배열
			result = new int[N]; //순열결과 저장할 배열 
			min = Integer.MAX_VALUE;
			
			for (int r = 1; r <= H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			} // 입력 받기 종료

			permutation(0);
			
			System.out.println("#" + t + " "+min);
			
			//테스트용 코드(무시하세요) 
//			tempMap = new int[H+2][W+2];
//			for(int r=1; r<=H; r++) {
//				for(int c=1; c<=W; c++) {
//					tempMap[r][c] = map[r][c];
//				}
//			}
//			crush(3,3);
//			gravity();
//			for(int k=1; k<=H; k++) {
//				System.out.println(Arrays.toString(tempMap[k]));
//			}
		}

	}

//	// W 중 N개를 뽑는 중복순열
	static void permutation(int cnt) {
		if (cnt == N) {
			tempMap = new int[H+2][W+2];
			for(int r=1; r<=H; r++) {
				for(int c=1; c<=W; c++) {
					tempMap[r][c] = map[r][c];
				}
			}

			for (int i = 0; i < N; i++) {
				// result[i]에 공을 떨어뜨릴 때 맨 위에 있는 벽돌의 위치 찾기
				int r = find(result[i], 1);

				// 그 위치에서 벽돌 깨뜨리기(상하좌우로!)
				crush(r, result[i]);
				gravity();
				
				
			}


			int m = countBlock();
			min = Math.min(m, min);

			return;
		}

		for (int i = 1; i <= W; i++) {
			result[cnt] = i;
			permutation(cnt + 1);
		}
	}

	// 구슬 출바알
	static void crush(int r, int c) {
		// result를 돌며, result에 있는 위치에서 구슬을 떨어뜨리자.
		//power저장
//		if (tempMap[r][c]==0) return;
		int power = tempMap[r][c] - 1;
		// 해당 위치 벽돌 다 부수기 !
		tempMap[r][c] = 0;


		for (int i = 1; i <= power; i++) {
			// 상
			if (r - i >= 1)
				crush(r - i, c);
			// 하
			if (r + i <= H)
				crush(r + i, c);
			// 좌
			if (c - i >= 1)
				crush(r, c - i);
			// 우
			if (c + i <= W)
				crush(r, c + i);
		}
		
		

	}

	static int find(int c, int k) {
		if (k == 0) {
			int fromB = 0;
			for (int h = H; h >= 1; h--) {
				// 밑에서 부터 볼 때는 처음으로 0인 지점을 찾기
				if (tempMap[h][c] == 0) {
					fromB = h;
					break;
				}
			}

			return fromB;
		}

		else {
			int fromT = 0;
			for (int h = 1; h <= H; h++) {
				// 위에서 부터 볼 때는 처음으로 0이 아닌 지점 찾기
				if (tempMap[h][c] != 0) {
					fromT = h;
					break;
				}
			}
			return fromT;
		}

	}

	static void gravity() {
		//가로를 다 돌면서
		for(int c=1; c<=W; c++) {
			Stack<Integer> stack = new Stack<>();
			for(int r=1; r<=H; r++) {
				if(tempMap[r][c]!=0) stack.push(tempMap[r][c]);
			}
			
			for(int r=H; r>=1; r--) {
				if(!stack.isEmpty()) {
					tempMap[r][c] = stack.pop();
				}else {
					tempMap[r][c] = 0;
				}
			}
		}
	}
	
	static int countBlock() {
		int ans = 0;
		for(int r=1; r<=H; r++) {
			for(int c=1; c<=W; c++) {
				if(tempMap[r][c]!=0) ans++;
			}
		}
		return ans;
	}

}
