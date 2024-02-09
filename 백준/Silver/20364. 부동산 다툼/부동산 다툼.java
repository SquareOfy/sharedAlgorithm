import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static int[] wish;
    static boolean[] ground;
    public static void main(String[] args) throws IOException {

        input();
        for(int i=1; i<=Q; i++){
            int target = wish[i];
            int cnt =0;
            int result = 0;
            boolean flag=true;
            while(target >=1){

                if(ground[target]) {
                    result = target;

                }
                target/=2;
            }

            if(result==0) ground[wish[i]] = true;
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        ground = new boolean[N+1];
        wish = new int[Q+1];
        for(int q=1; q<=Q; q++){
            wish[q] = Integer.parseInt(br.readLine());
        }
    }
}