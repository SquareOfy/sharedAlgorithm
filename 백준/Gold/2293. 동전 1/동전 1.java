import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] value = new int[n + 1];

        int[] dp = new int[k + 1];

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }


        for (int j = 0; j < n; j++) {
            for (int i =value[j]; i <= k; i++) {
                    dp[i] += dp[i - value[j]];

            }
        }

        System.out.println(dp[k]);

    }
}