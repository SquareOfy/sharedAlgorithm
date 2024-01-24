import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        BigInteger[] dp = new BigInteger[N+1];

        dp[0] = new BigInteger("0");
        if(N>=1)  dp[1] = new BigInteger("1");

        for(int i=2; i<=N; i++){
            
            dp[i] = dp[i-1].add(dp[i-2]);
        }

        System.out.println(dp[N]);
    }
}