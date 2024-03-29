import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input();

        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(map[i][j]>0){
                   int du = i+map[i][j];
                   int dv = j+map[i][j];
                   //아래 이동 가능하면
                   if(du<N){
                       dp[du][j] += dp[i][j];
                   }

                   if(dv<N){
                       dp[i][dv] +=dp[i][j];
                   }
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }


    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}