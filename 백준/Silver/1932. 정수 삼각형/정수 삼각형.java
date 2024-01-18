import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<=n; m++){

                arr[n][m] = Integer.parseInt(st.nextToken());

//                arr[idx++] = Integer.parseInt(st.nextToken());
            }


        }

        int[][] dp = new int[N+1][N+1];
        dp[0][0] = arr[0][0];
        for(int n=1; n<=N; n++){
            for(int m=0; m<n+1; m++){


                if(m>0){
                    dp[n][m] = Math.max(dp[n-1][m-1], dp[n-1][m])+arr[n][m];
                }

                else {
                    dp[n][m] = dp[n-1][m]+arr[n][m];
                }




            }
        }

        System.out.println(Arrays.stream(dp[N-1]).max().getAsInt());
    }
}