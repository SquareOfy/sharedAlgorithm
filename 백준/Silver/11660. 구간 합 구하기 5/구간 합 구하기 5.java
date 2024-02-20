import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[][] dp;
    static int[][] arr;



    public static void main(String[] args) throws IOException {

        input();

        for(int n=1; n<=N; n++){
            for(int m=1; m<=N; m++){
                dp[n][m] = dp[n-1][m]+dp[n][m-1]-dp[n-1][m-1]+arr[n][m];
            }
        }



        for(int m=0; m<M ; m++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            sb.append(dp[x2][y2]-(dp[x1-1][y2]+dp[x2][y1-1])+dp[x1-1][y1-1]).append("\n");
        }


        System.out.println(sb.toString());

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp= new int[N+1][N+1];
        arr= new int[N+1][N+1];
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=1; m<=N; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

    }

}