
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        final int M = 1234567891;
        long pow = 1;
        String str = br.readLine();
        long sum = 0;

        for(int n=0; n<N; n++){
            sum += (str.charAt(n) - 96) *pow;

            pow = (pow*31) % M;


        }


        System.out.println(sum%M);
    }
}
