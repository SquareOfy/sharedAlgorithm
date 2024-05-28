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

        if(K==0){
            long answer = 1;

            for(int i=1; i<=N+M-2; i++){
                answer*=i;
            }

            for(int i=2; i<=N-1; i++){
                answer/=i;
            }

            for(int i=2; i<=M-1; i++){
                answer/=i;
            }

            System.out.println(answer);
        }else{

            //동그라미 위치
            int r = K/M;
            int c = K%M-1;


            long first = 1;

            for(int i=1; i<=r+c; i++){
                first*=i;
            }
            for(int i=1; i<=r; i++){
                first/=i;
            }
            for(int i=1; i<=c; i++){
                first/=i;
            }

            long second = 1;

            for(int i=1; i<=N+M-r-c-2; i++){
                second*=i;
            }
            for(int i=1; i<=N-r-1; i++){
                second/=i;
            }
            for(int i=1; i<=M-c-1; i++){
                second/=i;
            }



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