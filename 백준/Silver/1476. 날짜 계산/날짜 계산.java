import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int E,S,M;

    public static void main(String[] args) throws IOException {

        input();

        int max = 15*28*19;

        int e =1, s=1, m=1;
        int answer =1;
        while(true){
            if(e==E && s==S && m==M){
                break;
            }

            answer++;
            e++;
            s++;
            m++;
            if(e==16) e=1;
            if(s==29) s=1;
            if(m==20) m=1;
        }

        System.out.println(answer);



    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}