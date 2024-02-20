import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();
    static int N,M,K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int n=i; n<=x; n++){
                for(int m=j; m<=y; m++){
                    sum+=arr[n][m];
                }
            }
            sb.append(sum).append("\n");

        }
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for(int n=1; n<N+1; n++){
            st=new StringTokenizer(br.readLine());
            for(int m=1; m<M+1; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        K = Integer.parseInt(br.readLine());

    }
}