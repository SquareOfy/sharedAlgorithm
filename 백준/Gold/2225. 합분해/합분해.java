import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();


    static int N,K;

    public static void main(String[] args) throws IOException {
        input();

        long[][] dp = new long[N+1][K+1];

        int mod = 1000000000;

        Arrays.fill(dp[0],1);
        for(int i=0; i<=K; i++){
            dp[0][i] = 1;
        }

        for(int n=1; n<=N; n++){
            for(int k=1; k<=K; k++){
                dp[n][k] = (dp[n][k-1]+dp[n-1][k])%mod;
            }

        }

        System.out.println(dp[N][K]);


    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}