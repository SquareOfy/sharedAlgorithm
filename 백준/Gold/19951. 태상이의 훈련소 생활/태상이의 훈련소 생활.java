import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[] height;
    static int[][] order;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        input();
        int[] answer = new int[N+1];

        for(int m=0; m<M; m++){
            int start = order[m][0];
            int end = order[m][1];
            int value = order[m][2];

            answer[start]+=value;
            if(end+1<=N) answer[end+1] -=value;
        }

        for(int n=1; n<=N; n++){
            answer[n] += answer[n-1];
        }

        for(int n=1; n<=N; n++){
            answer[n] += height[n];
            sb.append(answer[n]).append(" ");
        }

        System.out.println(sb.toString());


    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        height = new int[N+1];
        order = new int[M][3];
        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=N; n++){
            height[n] = Integer.parseInt(st.nextToken());
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++){
                order[m][i] = Integer.parseInt(st.nextToken());
            }
        }

    }

}