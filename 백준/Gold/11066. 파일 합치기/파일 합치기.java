import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            int[][] dp = new int[N + 1][N + 1]; //dp[i][j] : i~j번 파일을 하나로 합치는 최소 비용
            int[][] sum = new int[N+1][N+1];

            st = new StringTokenizer(br.readLine());

            for (int n = 1; n <= N; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                for(int j=i; j<=N; j++){
                    sum[i][j] = sum[i][j-1]+arr[j];
                }
            }


            for (int len = 2; len <= N; len++) {
                for (int i = 1; i <= N - len + 1; i++) {
                    int j= i+len-1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+sum[i][j]);
                    }

                }
            }

            sb.append(dp[1][N]).append("\n");



        }
        System.out.println(sb.toString());
    }
}