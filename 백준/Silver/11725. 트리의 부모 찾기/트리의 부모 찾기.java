import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int[] parents;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];

        parents = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

           graph[x].add(y);
           graph[y].add(x);


        }



        dfs(1);



        for(int i =2; i<=N; i++){
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void dfs(int idx){
        visited[idx] = true;

        for(int i : graph[idx]){
            if(!visited[i]){
                parents[i] = idx;
                dfs(i);
            }
        }
    }




}