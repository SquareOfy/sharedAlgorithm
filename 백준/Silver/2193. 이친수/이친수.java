import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][] dp = new long[N+1][2];

        dp[1][1] = 1;
        for(int n=2; n<=N; n++){
            dp[n][0] = dp[n-1][0]+dp[n-1][1];
            dp[n][1] = dp[n-1][0];
        }


        System.out.println(dp[N][0]+dp[N][1]);


    }
}