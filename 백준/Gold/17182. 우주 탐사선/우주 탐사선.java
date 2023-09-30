import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] dist;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());


        int[][] adj = new int[N][N];
        dist = new int[N][N];

       visited = new boolean[N];

        visited[S] = true;
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                adj[i][j]=Integer.parseInt(st.nextToken());
                dist[i][j] = adj[i][j];

            }
        }

        int INF = Integer.MAX_VALUE;
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N;j++){
//                if(i!=j && dist[i][j]==0) dist[i][j] = INF;
//            }
//        }

        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j] = dist[i][k]+dist[k][j];

                    }
                }
            }
        }



        dfs(S, 1, 0);

        if(answer !=INF)  System.out.println(answer);
        else System.out.println(0);







    }


    static void dfs(int idx, int cnt, int d){
        if(cnt==N){
            answer = Math.min(answer, d);
            return;
        }

        if(answer < d) return;
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, cnt+1, d+dist[idx][i]);
            visited[i]=false;
        }
    }
}
