import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int[] dp;
	static int[] num;
	static int inf = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		
		dp = new int[N+1];
		num = new int[3];

		System.out.println(operation(N));

	}

	static int operation(int N) {
		int n=1;
		dp[1] = 0;
		while (n < N) {
			n++;
			Arrays.fill(num, inf);
			if(n%3 ==0) num[0] = dp[n/3]+1;
			if(n%2 ==0) num[1] = dp[n/2]+1;
			num[2] = dp[n-1]+1;
			
			dp[n] = Arrays.stream(num).min().getAsInt();
		}
		
		return dp[N];

	}
}
