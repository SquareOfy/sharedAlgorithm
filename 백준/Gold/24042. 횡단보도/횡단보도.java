import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static List<Node>[] edges;


    static class Node {
        int end;
        long time;

        Node(int end, long time) {
            this.end = end;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {

        input();

        long[] dist = new long[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int) (o1.time - o2.time);
            }
        });

        long INF = Long.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq.add(new Node(1, 0));


        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[now.end]<now.time) continue;

            for (Node next : edges[now.end]) {
//                long time  = (next.time - now.time)%M;
//                if(time<0) time+= M;

                long time = now.time % M;
                time = next.time - time;
                if(time<0) time+= M;

                long nextTime = now.time + time;
                if(dist[next.end]>nextTime){
                    dist[next.end] = nextTime;
                    pq.add(new Node(next.end, dist[next.end]));

                }


            }
        }

        System.out.println(dist[N]);


    }

    public static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        for (int n = 1; n <= N; n++) {
            edges[n] = new ArrayList<>();
        }
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(new Node(b, m));
            edges[b].add(new Node(a, m));
        }


    }
}