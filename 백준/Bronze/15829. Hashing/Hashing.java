
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        final int M = 1234567891;
        String str = br.readLine();
        double sum = 0;

        for(int n=0; n<N; n++){
            int a = (int) str.charAt(n) - 96;

            sum +=(a * (Math.pow(31, n))) % M;


        }


        System.out.println((long) sum);
    }
}
