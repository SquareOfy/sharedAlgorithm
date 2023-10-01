import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N];
        int[][] dp = new int[N+1][3];
        for(int n=0; n<N; n++){
            map[n] = Integer.parseInt(br.readLine());
        }

        dp[0][1] = map[0];
      if(N==1){
          System.out.println(dp[0][1]);
          return;
      }
        dp[1][1] = map[1]; //2칸 한번에 점프
        dp[1][2] = dp[0][1]+map[1]; //0번 칸에서 1칸 점프

        if(N==2){
            System.out.println(Math.max(dp[N-1][2], dp[N-1][1]));
            return;
      }



        dp[2][1] = dp[0][1]+map[2];
        dp[2][2] = dp[1][1]+map[2];


        int idx = 3;
        while(idx <= N-1){
            dp[idx][1] = Math.max(dp[idx-2][1]+map[idx], dp[idx-2][2]+map[idx]);
            dp[idx][2] = dp[idx-1][1]+map[idx];
            idx++;
        }


        System.out.println(Math.max(dp[N-1][2], dp[N-1][1]));

    }
}
