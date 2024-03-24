import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] pay;
    static int[] time;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();

        int max = 0;
        for (int n = 0; n < N; n++) {
            int next = n + time[n];
            if (next <= N) {
                dp[next] = Math.max(dp[next], pay[n] + dp[n]);
                max = Math.max(dp[next], max);
            }

            dp[n+1] = Math.max(dp[n], dp[n+1]);
        }


        System.out.println(max);
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        pay = new int[N + 1];
        time = new int[N + 1];
        dp = new int[N + 1];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            time[n] = Integer.parseInt(st.nextToken());
            pay[n] = Integer.parseInt(st.nextToken());
            if (n + time[n] > N) pay[n]= 0;
        }
    }
}