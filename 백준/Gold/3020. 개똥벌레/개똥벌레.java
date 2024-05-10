import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,H;
    static int[] bottom, top;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input();


        //누적합 시키기
        for(int i=H-1; i>=1; i--){
            bottom[i] += bottom[i+1];
        }

        int[] answer = new int[H+1];
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i=1; i<=H; i++){
            top[i] += top[i-1];
            answer[i] = top[i]+bottom[i];
            if(min>answer[i]) {
                min = answer[i];
                cnt=1;
            }else if(min==answer[i]) cnt++;
        }

        sb.append(min).append(" ").append(cnt);
        System.out.println(sb.toString());


    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        top = new int[H+1];
        bottom = new int[H+1];

        for(int n=0; n<N; n++){
            int h = Integer.parseInt(br.readLine());
            if(n%2!=0) top[H+1-h] ++;
            else bottom[h] ++;
        }
    }
}