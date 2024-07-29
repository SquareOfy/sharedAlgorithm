import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int mod = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] matrix = {{1,1},{1,0}};

        long[][] answer = pow(n, matrix);
        System.out.println(answer[0][1]%mod);

    }

    static long[][] multi(long[][] m1, long[][] m2){
        long[][] result = new long[2][2];

        for(int r=0; r<2; r++){
            for(int c=0; c<2; c++) {
                for (int k = 0; k < 2; k++) {
                    result[r][c] += (m1[r][k] * m2[k][c])%mod;
                }
                result[r][c] %= mod;
            }
        }

        return result;
    }
    static long[][] pow(long n, long[][] matrix){
        if(n==1){
            return matrix;
        }

        long[][] result = pow(n/2, matrix);
        result = multi(result, result);
        if(n%2 ==0){
            return result;
        }
        return multi(result, matrix);

    }
}
