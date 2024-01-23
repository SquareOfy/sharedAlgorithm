import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        final int mod = 1000000009;
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[n+1];

            dp[0] = 1;
            dp[1]=1;

            for(int i=1; i<=n; i++){
                if(i==2) dp[i] = 2;
                if(i==3) dp[i] = 2;

                if(i>3) dp[i] += dp[i-2]; // 양쪽 +1
                if(i>=4) dp[i] += dp[i-4]; //양쪽 +2
                if(i>=6) dp[i] += dp[i-6]; //양쪽 +3

                dp[i] %=mod;

            }


            sb.append(dp[n]).append("\n");
       }
        System.out.println(sb.toString());
    }

}