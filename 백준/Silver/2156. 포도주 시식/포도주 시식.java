import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] glass = new int[n+1];
        for(int i=1; i<=n; i++){
            glass[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][3];

        dp[1][0] = glass[1];
        if(n>=2) {
            dp[2][1] = glass[2];
            dp[2][2] = glass[1]+glass[2];
        }
        for(int i=3; i<=n; i++){
            dp[i][1] = Math.max(Math.max(dp[i-2][1],dp[i-2][2]), dp[i-2][0]) + glass[i];
            dp[i][2] = dp[i-1][1]+glass[i];
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
        }



        System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]),dp[n][2]));

    }
}