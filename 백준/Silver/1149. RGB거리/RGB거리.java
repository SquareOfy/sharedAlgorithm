

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        int[][] dp = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<3; i++){
            dp[0][i] = map[0][i];
        }

        for(int i=1; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+map[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+map[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0])+map[i][2];

        }

        System.out.println( Arrays.stream(dp[N-1]).min().getAsInt());
    }
}
