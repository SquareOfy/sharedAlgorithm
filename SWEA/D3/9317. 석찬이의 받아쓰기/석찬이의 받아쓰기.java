import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            String str1  =  br.readLine();
            String str2 = br.readLine();
            int count =0;
            for(int n=0; n<N; n++){
                if(str1.charAt(n) == str2.charAt(n)) count ++;
            }


            System.out.printf("#%d %d\n", t, count);
        }

    }
}