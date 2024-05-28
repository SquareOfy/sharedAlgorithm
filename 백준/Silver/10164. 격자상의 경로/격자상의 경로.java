import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M,K;

    public static void main(String[] args) throws IOException {

        input();
        BigInteger[] factorial = new BigInteger[N+M+1];
        factorial[0] = BigInteger.valueOf(1);
        for(int i=1; i<=N+M; i++){
            factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));
        }


        if(K==0){

            BigInteger answer = factorial[N+M-2].divide(factorial[N-1]).divide(factorial[M-1]);

            System.out.println(answer);
        }else{

            //동그라미 위치
            int r = K%M != 0 ? K/M : K/M-1;
            int c = K%M ==0 ? M-1 : K%M-1;



            BigInteger first = (factorial[r+c].divide(factorial[r])).divide(factorial[c]);

            BigInteger second = factorial[N+M-r-c-2].divide(factorial[N-r-1]).divide(factorial[M-c-1]);



            System.out.println(first.multiply(second));

        }

    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

}