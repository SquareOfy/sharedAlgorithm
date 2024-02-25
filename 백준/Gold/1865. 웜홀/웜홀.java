import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    static List<Edge> list;
    static int N;

    public static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.cost = cost;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            dist = new long[N + 1];

            list = new ArrayList<>();

            //도로 입력받기
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list.add(new Edge(start, end, cost));
                list.add(new Edge(end, start, cost));
            }

            //웜홀 입력받기
            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.add(new Edge(start, end, cost * (-1)));
            }


            if (bellmanFord()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }

        System.out.println(sb.toString());
    }

    public static boolean bellmanFord() {
        //출발지 for문
        outer:
        for (int i = 1; i <= N; i++) {

            //출발지 제외 INF로 채우기
            Arrays.fill(dist, INF);
            dist[i] = 0;

            boolean check = false;

            //출발지에서 N-1번 dist 갱신
            //N번째에 도달한다면 음수사이클 발생했다는 뜻
            for (int k = 1; k <= N; k++) {
                check = false;
                for (Edge edge : list) {

                    if (dist[edge.start] == INF) continue;
                    if (dist[edge.end] > dist[edge.start] + edge.cost) {
                        dist[edge.end] = dist[edge.start] + edge.cost;

                        check = true;
                        if (k == N) {
                            return true;
                        }

                    }
                }
                if(!check) continue outer;
            }
        }
        return false;
    }
}