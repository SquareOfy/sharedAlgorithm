import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
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
        sb.append(dp[len2][len1]).append("\n");


        if(dp[len2][len1]!=0){
            int j =len1;
            int i = len2;
            String answer = "";
            while(i>=1 && j>=1){
                if(dp[i-1][j]==dp[i][j]) {
                    i--;
                }else if(dp[i][j] == dp[i][j-1]){
                    j--;
                }else {
                    answer+=str1.charAt(j-1);
                    j--;
                    i--;

                }

            }

            StringBuffer stringBuffer = new StringBuffer(answer);

            sb.append(stringBuffer.reverse().toString());

        }


        System.out.println(sb.toString());
    }
}