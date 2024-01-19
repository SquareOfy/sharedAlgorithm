
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new ArrayList[N+1];

        for(int n=0; n<=N; n++){
            graph[n] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
        }

        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1.cost, o2.cost));

        int max = 0;
        for(int i=1; i<=N; i++){
            Arrays.fill(dist, INF);
            dist[i] = 0;
            pq.add(new Node(i, 0));

            int tmpMax = 0;
            while(!pq.isEmpty()){

                Node current = pq.poll();
                tmpMax = Math.max(tmpMax, current.cost);

                for(int j=0; j<graph[current.idx].size(); j++){
                    Node next = graph[current.idx].get(j);
                    if(dist[next.idx] > current.cost + next.cost){
                        dist[next.idx] = current.cost+ next.cost;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            }
            int go = dist[X];
            Arrays.fill(dist, INF);
            dist[X] = 0;
            pq.add(new Node(X, 0));

            while(!pq.isEmpty()){
                Node current = pq.poll();
                for(int j=0; j<graph[current.idx].size(); j++){
                    Node next = graph[current.idx].get(j);
                    if(dist[next.idx] > current.cost + next.cost){
                        dist[next.idx] = current.cost+ next.cost;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            }

            int back = dist[i];

            max = Math.max(max, go+back);

        }


        System.out.println(max);








    }
}