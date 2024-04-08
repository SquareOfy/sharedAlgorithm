import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        input();

        int[][] dp = new int[N+1][3];

        int answer = Integer.MAX_VALUE;

        //r,g,b
        for(int i=0; i<3; i++){
            Arrays.fill(dp[1], 1001);
            dp[1][i] = map[1][i];
            for(int j=2; j<=N; j++){
                dp[j][0] = map[j][0]+Math.min(dp[j-1][1], dp[j-1][2]);
                dp[j][1] = map[j][1]+Math.min(dp[j-1][0], dp[j-1][2]);
                dp[j][2] = map[j][2]+Math.min(dp[j-1][0], dp[j-1][1]);
            }

            for(int k=0; k<3; k++){
                if(i!=k) answer = Math.min(answer, dp[N][k]);
            }
        }


        System.out.println(answer);

    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][3];

        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++){
                map[n][i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}