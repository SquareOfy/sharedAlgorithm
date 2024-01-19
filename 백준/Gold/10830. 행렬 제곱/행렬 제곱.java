import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < N; m++) {
                matrix[n][m] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        int[][] result = pow(matrix, B);

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                sb.append(result[n][m]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }


    public static int[][] pow(int[][] matrix, long times){

        if(times ==1) return matrix;

        int[][] result = pow(matrix, times/2);

        result = multiplyMatrix(result, result);

        if(times%2 ==0) return result;
        return multiplyMatrix(result, matrix);
    }
    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {

        int[][] result = new int[N][N];


        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                for (int i = 0; i < N; i++) {
                    result[n][m] += (matrix1[n][i] * matrix2[i][m]) % 1000;
                    result[n][m] %= 1000;
                }
            }
        }
        return result;


    }

}