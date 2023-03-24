import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B, minGap;
	static int[] employees;
	static boolean[] flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//입력받기
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			minGap = Integer.MAX_VALUE;
			employees = new int[N];
			flag = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				employees[i] = Integer.parseInt(st.nextToken());
			}
			findAns(0);
			System.out.println("#"+t+" "+minGap);
			
			
		}
		
		
		
	}
	
	public static void findAns(int cnt) {
		
		if(cnt ==N) {
			int temp = 0;
			for(int i=0; i<N; i++) {
				if(flag[i]) {
					temp += employees[i];
				}
			}
			if(temp>=B && Math.abs(temp-B)<minGap) minGap = Math.abs(temp-B);
			return;
		}
		flag[cnt] = true;
		findAns(cnt+1);
		flag[cnt] = false;
		findAns(cnt+1);
	}

}
