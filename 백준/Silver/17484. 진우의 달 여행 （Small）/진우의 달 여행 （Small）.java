import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;

    static int[][] map;

    public static void main(String[] args) throws IOException {

        input();

        int[][][] dp = new int[N+1][M+1][3];



        for(int n=1; n<=N; n++){
            for(int m=0; m<=M; m++){
                Arrays.fill(dp[n][m], Integer.MAX_VALUE);
            }
        }
        for(int m=1; m<=M; m++){
            Arrays.fill(dp[1][m], map[1][m]);
        }

        for(int n=2; n<=N; n++){

            for(int m=1; m<=M; m++){
                if(m!=M) dp[n][m][0] = Math.min(dp[n-1][m+1][1], dp[n-1][m+1][2])+map[n][m];
                if(m!=1) dp[n][m][2] = Math.min(dp[n-1][m-1][0], dp[n-1][m-1][1])+map[n][m];
                dp[n][m][1] = Math.min(dp[n-1][m][0],dp[n-1][m][2])+map[n][m];
            }
        }





        int min = Integer.MAX_VALUE;

        for(int j = 1; j <= M; j++) {
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, dp[N][j][i]);
            }
        }


        System.out.println(min);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];

        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=1; m<=M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

    }
}