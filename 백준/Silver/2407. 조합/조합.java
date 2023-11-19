
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger result1 = BigInteger.valueOf(1);
        BigInteger result2 = BigInteger.valueOf(1);

        for(int i=0; i<m; i++){
            result1 = result1.multiply(new BigInteger(String.valueOf(n-i)));
            result2 = result2.multiply(new BigInteger(String.valueOf(i+1)));
        }



        System.out.println(result1.divide(result2));

    }
}
