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

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int[] dp = new int[N+1];

        for(int n=1; n<=N; n++){
            dp[n] = arr[n];
        }


        dp[1] = arr[1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }

        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}