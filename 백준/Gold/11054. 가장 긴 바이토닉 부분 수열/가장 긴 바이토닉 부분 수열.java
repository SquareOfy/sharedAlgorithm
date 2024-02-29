import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=1; n<=N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][2];
        //0은 그 지점까지 증가하는거, 1은 감소하는 수열 길이

        for(int n=1; n<=N; n++){
            Arrays.fill(dp[n],1);
        }
        int cnt = 1;

        for(int n=1; n<=N; n++){
            for(int m=1; m<n; m++){
                //증가 개수 세기
                if(arr[m]<arr[n]){
                   dp[n][0] = Math.max(dp[n][0], dp[m][0]+1);
                }
            }

        }

        for(int n=N; n>0; n--){
            for(int m=N; m>n; m--){
                if(arr[m]<arr[n]){
                    dp[n][1] = Math.max(dp[n][1], dp[m][1]+1);
                }
            }

            cnt = Math.max(cnt, dp[n][0]+dp[n][1]);
        }
        
        System.out.println(cnt-1);
    }
}