
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] adj = new int[N][N];
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            adj[start][end] = 1;
            adj[end][start] = 1;
        }

        int INF = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i!=j && adj[i][j]==0) adj[i][j] = INF;
            }
        }


        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    if (adj[i][k] != INF && adj[k][j] != INF) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                        adj[j][i] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }
        }



        int idx = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                sum+=adj[i][j];
            }
            if(min>sum){
                min = sum;
                idx = i;
            }
            sum =0;

        }

        System.out.println(idx+1);
    }

}
