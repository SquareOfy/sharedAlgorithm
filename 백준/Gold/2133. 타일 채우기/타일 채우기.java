import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0]=1;
        if (N >= 2) dp[2] = 3;

        for (int n = 4; n <= N; n += 2) {
            dp[n] = dp[n - 2] * 3 + dp[n - 4] * 2;
            for(int j=6; j<=n; j+=2){
                dp[n]+= dp[n-j]*2;
            }
        }

        System.out.println(dp[N]);

    }
}