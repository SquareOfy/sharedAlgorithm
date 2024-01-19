import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long N;
    static final int mod = 1000000007;
    static final long[][] fiboArr = new long[][] {{1,1},{1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());



        long[][] result = pow(fiboArr, N);
        System.out.println(result[0][1]%mod);
    }




    public static long[][] pow(long[][] matrix, long times){

        if(times ==1) return matrix;

        long[][] result = pow(matrix, times/2);


        result = multiplyMatrix(result, result);

        if(times%2 ==0) return result;
        return multiplyMatrix(result, matrix);
    }
    public static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {

        long[][] result = new long[2][2];


        for (int n = 0; n < 2; n++) {
            for (int m = 0; m < 2; m++) {
                for (int i = 0; i < 2; i++) {
                    result[n][m] += (matrix1[n][i] * matrix2[i][m]) % mod;
                    result[n][m] %= mod;
                }
            }
        }
        return result;


    }
}