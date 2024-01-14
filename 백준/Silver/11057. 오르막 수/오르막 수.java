import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        for(int i=1; i<=N; i++ ){
            dp[i][0] = 1;
        }

        for(int i=1; i<10; i++){
            dp[1][i] =1;
        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<10; j++){
                dp[i][j] += dp[i][j-1]+dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }



        int result = 0;
        for(int i=0; i<10; i++){
            result+= (dp[N][i]);
            result%=10007;
        }

        System.out.println(result);
    }
}