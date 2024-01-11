import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] value = new Integer[n+1];

        int[] dp = new int[100001];
        Arrays.fill(dp, 100001);

        for(int i=0; i<n; i++){
            value[i] = Integer.parseInt(br.readLine());
            if(value[i]<=k) dp[value[i]] =1;
        }


        for(int i=1; i<=k; i++){
            for(int j=0; j<n; j++){
                if(i-value[j]>=0){
                    dp[i] = Math.min(dp[i], dp[i-value[j]]+1);
                }

            }
        }

        System.out.println(dp[k]==100001? -1:dp[k]) ;

    }
}