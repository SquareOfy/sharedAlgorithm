import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int mod = 1000000000;

        long[][] dp = new long[N+1][10];

        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int n=2 ; n<=N; n++){
            for(int i=0; i<10; i++){
                if(i-1>=0) dp[n][i] += dp[n-1][i-1];
                if(i+1<=9) dp[n][i] += dp[n-1][i+1];
                dp[n][i] %= mod;
            }
        }


        long result = 0;
        for(int i=0; i<10; i++){
            result+=dp[N][i];
            result %= mod;
        }

        System.out.println(result);

    }
}