import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        

        int[] dp = new int[N+1];

        dp[1] = 1;
        if(N>=2) dp[2] = 0;
        if(N>=3) dp[3] = 1;
        if(N>=4) dp[4] = 1;

        for(int i=5; i<=N; i++){
            if(dp[i-1]==0||dp[i-3]==0||dp[i-4]==0) {
                dp[i] =  1;
            }
        }

        System.out.println(dp[N]==1 ? "SK" : "CY");

    }
}