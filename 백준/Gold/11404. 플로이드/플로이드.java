import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //노드 개수
        int M = Integer.parseInt(br.readLine()); //간선 개수


        final int INF = Integer.MAX_VALUE;
        long[][] dist = new long[N+1][N+1];

        for(int n=1; n<=N; n++){
            Arrays.fill(dist[n], INF);
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            dist[a][b] = Math.min(c, dist[a][b]);
        }



        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) dist[i][j] = 0;
            }
        }



        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }


        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(dist[i][j]==INF) sb.append(0);
                else sb.append(dist[i][j]);
                sb.append(" ");
            }
            sb.append("\n");

        }

        System.out.println(sb.toString());
    }
}