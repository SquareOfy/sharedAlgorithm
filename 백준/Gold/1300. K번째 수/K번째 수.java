import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static long N, K;


    public static void main(String[] args) throws IOException{

        input();


        long L = 1; long R = N*N;

        long answer = 0;
        while (L <= R) {

            long mid = (L+R)/2;
            long cnt =0;
            for(int i=1; i<=N; i++){
                cnt += Math.min(N, mid/i);

            }

            if(cnt >=K){
                answer = mid;
                R = mid -1;
            }else{
                L = mid +1;
            }


        }


        System.out.println(answer);


    }



    public static void input() throws IOException {

        N = Integer.parseInt(br.readLine());

        K = Integer.parseInt(br.readLine());



    }
}