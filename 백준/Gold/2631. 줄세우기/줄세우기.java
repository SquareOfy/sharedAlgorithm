import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        for(int n=1; n<=N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];

        int cnt = 1;
        Arrays.fill(dp, 1);
        for(int n=1; n<=N;n++){
            for(int j=1; j<n; j++){
               if(arr[n]>arr[j]) dp[n] = Math.max(dp[n], dp[j]+1);
            }
            if(cnt<dp[n]) cnt = dp[n];

        }


        System.out.println(N-cnt);
    }
}