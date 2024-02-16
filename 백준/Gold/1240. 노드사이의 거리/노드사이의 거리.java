import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Edge>[] edges;

    static boolean[] visited;

    public static class Edge{
        int node;
        int distance;

        public Edge(int node, int distance){
            this.distance =distance;
            this.node = node;
        }
    }

    public static void main(String[] args) throws IOException {

        //트리 입력
        input();

        //거리 알고 싶은 노드 입력
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            visited = new boolean[N+1];

            int answer= getDistance(a,b);

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());



    }

    public static int getDistance(int a, int b){

        visited[a] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0]==b) return now[1];
            for(Edge next : edges[now[0]]){
                if(!visited[next.node]){
                    visited[next.node] = true;
                    queue.add(new int[] {next.node, now[1]+next.distance});
                }
            }
        }
        return -1;
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];

        for(int n=0; n<=N; n++){
            edges[n] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b, d));
            edges[b].add(new Edge(a, d));

        }

    }
}