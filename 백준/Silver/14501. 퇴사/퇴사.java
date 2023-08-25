import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[] dp = new int[N+1];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(t+n<=N){

                dp[n+t] = Math.max(dp[n]+p,dp[n+t]);

                max= Math.max(max,dp[n+t]);
            }
            dp[n+1]= Math.max(dp[n+1], dp[n]);
        }

        System.out.println(max);




    }
}
