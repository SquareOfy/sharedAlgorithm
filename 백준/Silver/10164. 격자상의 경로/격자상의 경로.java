import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M,K;

    public static void main(String[] args) throws IOException {

        input();
        long[] factorial = new long[N+M+1];
        factorial[0] = 1;
        for(int i=1; i<=N+M; i++){
            factorial[i] = factorial[i-1]*i;
        }

        if(K==0){
            System.out.println(factorial[N+M-2]/factorial[N-1]/factorial[M-1]);
        }else{

            //동그라미 위치
            int r = K%M != 0 ? K/M : K/M-1;
            int c = K%M ==0 ? M-1 : K%M-1;



            long first = factorial[r+c]/factorial[r]/factorial[c];

            long second = factorial[N+M-r-c-2]/factorial[N-r-1]/factorial[M-c-1];



            System.out.println(first*second);

        }

    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

}