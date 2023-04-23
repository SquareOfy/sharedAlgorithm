import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T= sc.nextInt();
		int[] numbers = new int[T];
		for(int t=0; t<T; t++) {
			numbers[t] = sc.nextInt();
		}
		
		int N = Arrays.stream(numbers).max().getAsInt();
		
		long[] dp = new long[N+1];
		
		dp[1]=1;
		if(N>=2) dp[2] = 1;
		if(N>=3) dp[3] = 1;
		if(N>=4) dp[4] = 2;
		
		if(N>4) {
		for(int i=5; i<=N; i++) {
			
			dp[i] = dp[i-1]+dp[i-5];
		}

		}
		
		for(int t=0; t<T; t++) {
			sb.append(dp[numbers[t]]);
			if(t!=T-1) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}