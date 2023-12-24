import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[1] = 1;



        for(int n=2; n<=N; n++){
            if(dp[n]==0) {
                for (int m = 1; m <= Math.sqrt(n); m++) {
                    if (m * m == N) dp[n] = 1;
                }
            }

            if(dp[n] !=1){
                dp[n] = dp[n-1] +1;

                for(int m=0; m<=Math.sqrt(n); m++){
                    dp[n] = Math.min(dp[n], dp[n-(m*m)]+1);
                }
            }
        }


        System.out.println(dp[N]);
    }
}