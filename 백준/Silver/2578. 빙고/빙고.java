import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] bingo = new int[5][5];
		int[][] numbers = new int[5][5];

		int cnt = 0;
		int cntBingo = 0;

		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				bingo[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		outer: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cnt++;

				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (bingo[r][c] == numbers[i][j]) {

							bingo[r][c] = 0;
							if (checkR(bingo, r, c)) {
								cntBingo++;
							}

							if (checkC(bingo, r, c)) {
								cntBingo++;
							}
							if (checkCross1(bingo, r, c)) {
								cntBingo++;
							}
							if (checkCross2(bingo, r, c)) {
								cntBingo++;
							}

						}
						if (cntBingo >= 3) {
							break outer;
						}
					}
				}
			}
		}

		System.out.println(cnt);

	}

	static boolean checkR(int[][] bingo, int r, int c) {
		int rsum = 0;

		// 가로 빙고 체크
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[r][i] == 0)
				rsum++;
		}
		if (rsum == bingo.length)
			return true;

		return false;

	}

	static boolean checkC(int[][] bingo, int r, int c) {
		int csum = 0;

		// 세로 빙고 체크
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[i][c] == 0)
				csum++;

		}

		if (csum == bingo.length)
			return true;

		return false;

	}

	static boolean checkCross1(int[][] bingo, int r, int c) {
		int cross1 = 0;

		// 대각 라인인지 체크 후 맞다면 대각 빙고 체크
		if (r == c) {
			for (int i = 0; i < bingo.length; i++) {
				if (bingo[i][i] == 0)
					cross1++;
			}
			if (cross1 == bingo.length)
				return true;
		}

		return false;

	}

	static boolean checkCross2(int[][] bingo, int r, int c) {

		int cross2 = 0;

		if (r + c == bingo.length - 1) {
			for (int i = 0; i < bingo.length; i++) {
				if (bingo[i][bingo.length - 1 - i] == 0)
					cross2++;
			}
			if (cross2 == bingo.length)
				return true;
		}

		return false;

	}

}
