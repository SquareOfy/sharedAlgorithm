
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 3;
		
	
		for(int n=2; n<=N; n++) {
			dp[n] = (dp[n-2]+dp[n-1]*2)%9901;
			
		}
		
		
		System.out.println(dp[N]);

	}

}
