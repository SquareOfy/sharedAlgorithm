import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();


        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len2+1][len1+1];


        for(int i=1; i<=len2; i++){


            for(int j=1; j<=len1; j++){
                if(str1.charAt(j-1)==str2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[len2][len1]);





     }
}