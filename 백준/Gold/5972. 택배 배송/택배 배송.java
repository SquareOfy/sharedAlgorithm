import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static class Node{
        int num;
        int cost;

        Node(int end, int cost){
            this.num = end;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static List<Node>[] edges;

    public static void main(String[] args) throws IOException {
        input();

        int[] dist = new int[N+1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[1] = 0;

        //다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });

        pq.add(new Node(1, dist[1]));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int num = node.num;
            int cost = node.cost;


            for(Node next : edges[num]){
                if(next.cost+cost < dist[next.num]){
                    dist[next.num] = next.cost+cost;
                    pq.add(new Node(next.num, dist[next.num]));
                }
            }
        }

        System.out.println(dist[N]);



    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];

        for(int n=1; n<=N; n++){
            edges[n] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[start].add(new Node(end, cost));
            edges[end].add(new Node(start, cost));
        }
    }
}