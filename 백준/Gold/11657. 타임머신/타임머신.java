import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int M;

    static long[] dist;
    static List<Edge> edges;

    static final int INF = 1000000000;

    public static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new long[N + 1];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(dist, inf);



        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, cost));
        }


        boolean result = bellman(1);


        if (result) sb.append(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] != INF) sb.append(dist[i]).append("\n");
                else sb.append(-1).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean bellman(int start) {

        Arrays.fill(dist, INF);

        dist[start] = 0;

        for (int k = 1; k <= N; k++) {

            for(Edge edge : edges){
                if (dist[edge.start] !=INF && dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;
                    if (k == N) {
                        return true; //음수사이클 존재
                    }
                }

            }
        }


        return false;


    }


}