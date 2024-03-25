import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        for(int n=2; n<=N; n++){
            dp[n] = dp[n-1]+1;
            if(n%3 ==0) dp[n] = Math.min(dp[n], dp[n/3]+1);
            if(n%2==0) dp[n] = Math.min(dp[n], dp[n/2]+1);

        }

        sb.append(dp[N]).append("\n");


        int n = N;
        while(n!=1){
            sb.append(n).append(" ");
            if(n%3==0 && dp[n]==dp[n/3]+1) n/=3;
            else if(n%2==0 && dp[n]==dp[n/2]+1) n/=2;
            else if(dp[n]==dp[n-1]+1) n--;
        }
        sb.append(n);


        System.out.println(sb.toString());


    }
}