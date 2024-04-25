import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int abs = Math.abs(N);
        long[] dp = new long[abs+1];
        dp[0] = 0;
        if(abs>=1) dp[1] = 1;
        for(int i=2; i<=abs; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000000;
        }

        int answer = (int) Math.pow(-1, abs+1);


        if(dp[abs]==0) sb.append(0);
        else if(N>0) sb.append(1);
        else sb.append(answer);

        sb.append("\n");
        sb.append(dp[abs]);

        System.out.println(sb.toString());
    }
}