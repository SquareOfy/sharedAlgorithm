import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] items = new int[N][2];
        int[] dp = new int[K+1];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            items[n][0] =  Integer.parseInt(st.nextToken()); //무게
            items[n][1] = Integer.parseInt(st.nextToken()); //가치

        }



        for(int n=0; n<N; n++){
            for(int m=items[n][0]; m<=K; m++){
                dp[m-items[n][0]]= Math.max(dp[m-items[n][0]], dp[m]+items[n][1]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());



    }
}