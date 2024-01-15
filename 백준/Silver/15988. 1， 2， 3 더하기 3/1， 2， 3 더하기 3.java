import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];
            dp[1] =1;
            if(N>=2) dp[2] = 2;
            if(N>=3) dp[3] = 4;
            for(int n=4; n<=N; n++){
                dp[n] = (dp[n-1] + dp[n-2] + dp[n-3])%1000000009;
            }

            sb.append(dp[N]).append("\n");


        }

        System.out.println(sb.toString());
    }
}