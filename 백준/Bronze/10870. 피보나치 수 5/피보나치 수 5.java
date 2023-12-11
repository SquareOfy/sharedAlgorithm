import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] fiboArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        fiboArr = new int[21];

        fiboArr[0] = 0;
        fiboArr[1] = 1;
        System.out.println(fibo(N));

    }

    public static int fibo(int n){
        if(n!=1 && fiboArr[n]!=0) return fiboArr[n];


        if(n>=2) fiboArr[n] = fibo(n-1)+ fibo(n-2);
        return fiboArr[n];
    }
}