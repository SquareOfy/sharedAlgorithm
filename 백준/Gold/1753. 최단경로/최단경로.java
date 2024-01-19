import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int idx;
        int value;

        public Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        final int INF = Integer.MAX_VALUE;
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int startV = Integer.parseInt(br.readLine());

//        int[][] arr = new int[V+1][V+1];
        List<Node>[] arr = new ArrayList[V+1];


        for(int v=1; v<=V; v++){
            arr[v] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end, value));
        }


        int[] dist = new int[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));


        Arrays.fill(dist, INF);
        pq.add(new Node(startV, 0));
        dist[startV] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(dist[current.idx]< current.value) continue;

            for(int i=0; i<arr[current.idx].size(); i++){
                Node next = arr[current.idx].get(i);

                if(dist[next.idx] > current.value + next.value){
                    dist[next.idx] = current.value + next.value;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(dist[i]==INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString());


    }
}