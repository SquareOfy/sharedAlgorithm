import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[][] dist = new long[N][N];
        int[][] adj = new int[N][N];
        int inf = Integer.MAX_VALUE;


        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }


        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
//                if(i==j) dist[i][j] = 0;
                if(adj[i][j] ==0) dist[i][j] = inf;
                else dist[i][j] = adj[i][j];
            }
        }


        for(int k=0; k<N; k++){

            for(int i=0; i<N; i++){

                for(int j =0; j<N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] +dist[k][j]);


                }
            }
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(dist[i][j]==inf) sb.append(0).append(" ");
                else sb.append(1).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }
}