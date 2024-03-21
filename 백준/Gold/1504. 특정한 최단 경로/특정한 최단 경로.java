import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Node>[] edges;
    static int N, E;

    static int u, v;

    static int INF ;


    public static class Node{
        int end;
        int cost;
        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {

        input();
        INF = 200000000;

        int distUV = dijkstra(u, v);

        int stToU = dijkstra(1, u);
        int stToV = dijkstra(1, v);

        int uToEnd = dijkstra(u, N);
        int vToEnd = dijkstra(v, N);


        int answer = Math.min(stToU+distUV+vToEnd, stToV+distUV+uToEnd);
        System.out.println(answer >= INF ? -1 : answer);

    }


    public static int dijkstra(int start, int end){

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF );
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            //now랑 연결된 간선들 중에서 현재까지 온 거리보다
            for(Node next : edges[now.end]){
                if(dist[next.end] > next.cost + dist[now.end]){
                    dist[next.end] = next.cost+dist[now.end];
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }

        }


        return dist[end];

    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new List[N+1];
        for(int n=1; n<=N; n++){
            edges[n] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[a].add(new Node(b,cost));
            edges[b].add(new Node(a,cost));
        }

        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());




    }
}