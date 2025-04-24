import java.util.HashMap;
import java.util.Scanner;


class Solution {
	
	static int max;
	static int time;
	static int N;
	static int[] number;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			String num = sc.next();
			time = sc.nextInt();
			N = num.length();
			number = new int[N];
			max = 0;
			for(int i=0; i<N; i++) {
				number[i] = num.charAt(i)-'0';
			}
			
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int level, int idx) {
		if(level==time) {
			max = Math.max(max, getNumber());
			return;
		}
		
	
		
		for(int i=idx; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				swap(i, j);
				dfs(level+1, i);
				swap(i, j);
			}
		}
	}
	static void swap(int i, int j) {
		int tmp = number[i];
		number[i] = number[j];
		number[j] = tmp;
	}
	
	static int getNumber() {
		int digit = 1;
		int result = 0;
		for(int i=N-1; i>=0; i--) {
			result += number[i]*digit;
			digit*=10;
		}
		return result;
	}
		
	
}
