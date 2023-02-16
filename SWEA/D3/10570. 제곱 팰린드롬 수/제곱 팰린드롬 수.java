
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cnt = 0;
			for (int i = a; i <= b; i++) {
				if (checkNum(i)) {
					// 루트 확인하기
					for (int j = 1; j * j <= i; j++) {
						if (j * j == i && checkNum(j)) {
							cnt++;
						}

					}

				}
			}
			System.out.printf("#%d %d\n", t, cnt);
		}

	}

	static boolean checkNum(int num) {
		String s = String.valueOf(num);
		char[] check = new char[s.length()];
		for (int k = 0; k < check.length; k++) {
			check[k] = s.charAt(k);
		}
		int flag = 0;
		for (int k = 0; k < check.length / 2; k++) {
			if (check[k] != check[s.length() - 1 - k]) {
				flag = 1;
			}
		}
		if (flag == 0)
			return true;
		else
			return false;
	}

}
