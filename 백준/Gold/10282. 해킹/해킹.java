import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node{

        int end;
        int time;

        public Node(int end, int time){
            this.time = time;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int time = 0;
            List<Node>[] list = new ArrayList[n+1];
            for(int i=0; i<=n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<d; i++){
                st= new StringTokenizer(br.readLine());
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());

                list[start].add(new Node(end, sec));
            }

            int[] dist = new int[n+1];
            int INF = Integer.MAX_VALUE;

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
            for(int j=1; j<=n; j++){
                dist[j] = INF;
            }

            dist[c] = 0;
            pq.add(new Node(c, 0));

;


            while(!pq.isEmpty()){

                Node current = pq.poll();

                for(Node node : list[current.end]){
                    if(dist[node.end] > node.time+ current.time) {
                        dist[node.end] = node.time+current.time;

                        pq.add(new Node(node.end, dist[node.end]));

                    }

                }

            }

            int cnt =0;
            int max = 0;
            for(int i=1; i<=n; i++){
                if(dist[i]==INF) continue;
                cnt++;
                if(dist[i]>max ) max = dist[i];
            }



            sb.append(cnt).append(" ").append(max).append("\n");





            

        }
        System.out.println(sb.toString());
    }
}