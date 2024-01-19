import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int mod = 1000000007;
    static long[][] arr;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        factorial = new long[N+1];
        factorial[1]= 1;
        for(int i=2; i<=N; i++){
            factorial[i] = factorial[i-1]*i %mod;
        }

        System.out.println(binary(N,K));



    }

    public static long binary(int n, int k){
        if(k==0 || k==n) return 1;

        long a = factorial[n];
        long b = factorial[k] * factorial[n-k] %mod;
        

        int exp = mod -2;


        long b2 = pow(b, exp);


        return (a*b2) % mod;

    }


    public static long pow(long a, long b){
        if(b==0) return 1;
        if(b==1) return a%mod;

        long k = pow(a, b/2);
        if(b%2==0){
            return k*k%mod;
        }else{
            return (k*k%mod)*a%mod;
        }


    }
}