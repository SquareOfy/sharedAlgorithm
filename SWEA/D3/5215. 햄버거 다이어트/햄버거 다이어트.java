import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static int N;
	static int L;
	static int[] scores;
	static int[] calories;
	static int maxScore;


	static 	boolean[] flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			maxScore = 0;
		
			flag = new boolean[N];
			scores = new int[N];
			calories = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			powerSet(0);
			System.out.println("#"+t+" " +maxScore);
			
			
		}
	}

	
	public static void powerSet(int cnt) {

		int sumCalorie=0;
		int temp =0;
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				if(flag[i]) {
					temp += scores[i];
					sumCalorie += calories[i];
				}
			}
		
			if(sumCalorie <= L && temp >= maxScore) {
				maxScore = temp;
			}
			return;
		}
		
			flag[cnt] = true;
			powerSet(cnt+1);
			
			flag[cnt] = false;
			powerSet(cnt+1);
			
		}
	

		
}
