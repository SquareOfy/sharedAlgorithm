import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드개수

        int m = Integer.parseInt(st.nextToken()); //수색범위
        int r = Integer.parseInt(st.nextToken()); //간선 개수

        int[] item = new int[N + 1];
        long[][] dist = new long[N + 1][N + 1];
        final int INF = Integer.MAX_VALUE;


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) dist[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            item[n] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            dist[a][b] = Math.min(l, dist[a][b]);
            dist[b][a] = Math.min(l, dist[b][a]);

        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }


        int max = 0;

        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if(dist[i][j]<=m) {
                    tmp += item[j];
                }
            }
            max = Math.max(max, tmp);
        }


        System.out.println(max);

    }
}