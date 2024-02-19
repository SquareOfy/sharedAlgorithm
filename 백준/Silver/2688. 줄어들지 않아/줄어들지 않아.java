import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringBuilder sb = new StringBuilder();


    static int T,N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            input();

            long[][] dp = new long[N+1][10];

            for(int i=1; i<=N; i++ ){
                dp[i][0] = 1;
            }

            for(int i=1; i<10; i++){
                dp[1][i] =1;
            }

            for(int i=2; i<=N; i++){
                for(int j=1; j<10; j++){
                    dp[i][j] += dp[i][j-1]+dp[i-1][j];
                }
            }
            long answer = 0;
            for(int i=0; i<10; i++){
                answer+= dp[N][i];
            }

            sb.append(answer).append("\n");

        }
        System.out.println(sb.toString());
    }


    public static void input() throws IOException {

        N = Integer.parseInt(br.readLine());


    }
}