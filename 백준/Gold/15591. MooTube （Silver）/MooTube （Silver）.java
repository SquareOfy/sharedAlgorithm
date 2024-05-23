import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,Q;

    static List<Node>[] edges;
    static int[][] question;




    public static void main(String[] args) throws IOException {

        input();
        StringBuilder sb = new StringBuilder();

        int[][] dist = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] =0;
        }
        //dist[i] 값 구하기..?
        for(int i=1; i<=N; i++){
            Arrays.fill(visited, false);
            visited[i] = true;


            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.r-o2.r;
                }
            });

            for(Node node : edges[i]){
                pq.add(node);
                visited[node.end] = true;
            }

            while(!pq.isEmpty()){
                Node now = pq.poll();

                dist[i][now.end] = Math.min(dist[i][now.end], now.r);

                for(Node node: edges[now.end]){
                    if(!visited[node.end]){
                        pq.add(new Node(node.end, Math.min(now.r, node.r)));
                        visited[node.end] = true;
                    }
                }
            }
        }



        for(int q=0; q<Q; q++){
            int k = question[q][0];
            int v = question[q][1];
            int cnt =0;
            for(int n=1; n<=N; n++){
                if(dist[v][n]>=k) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());


    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];

        for(int n=0; n<=N; n++){
            edges[n] = new ArrayList<>();
        }

        for(int n=0; n<N-1; n++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            edges[p].add(new Node(q,r));
            edges[q].add(new Node(p,r));
        }

        question = new int[Q][2];
        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            question[q][0] = k;
            question[q][1] = v;
        }

    }

    static class Node{
        int end;
        int r;

        Node(int end, int r){
            this.end = end;
            this.r = r;
        }
    }
}