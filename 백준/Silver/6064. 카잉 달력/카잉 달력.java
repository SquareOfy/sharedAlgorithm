import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            int g = gcd(M, N);

            int l = M*N/g;

            int answer = -1;
            while(x<=l){
                if((x%N ==y) || (x%N)+N ==y) {
                   answer = x;
                    break;
                }
                x+=M;
            }


            sb.append(answer).append("\n");

        }

        System.out.println(sb.toString());


    }

    public static int gcd(int a, int b){
        int r = a%b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;
        }

        return b;


    }
}