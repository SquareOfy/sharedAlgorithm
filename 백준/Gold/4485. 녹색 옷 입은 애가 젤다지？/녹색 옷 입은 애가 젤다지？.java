import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dr = new int[] {-1,0,1,0};
    static int[] dc = new int[] {0, -1, 0, 1};

    public static class Node implements Comparable<Node> {
        int r;
        int c;
        int dist;


        @Override
        public int compareTo(Node o) {
            return this.dist-o.dist;
        }

        Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws IOException {

        int t = 1;
        while(true){
            input();

            if(N ==0) break;

            //거리배열 초기 세팅
            int[][] dist = new int[N][N];
            for(int n=0; n<N; n++){
                Arrays.fill(dist[n], INF);
            }


            //출발지 dist =0
            dist[0][0] = map[0][0];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0,0,dist[0][0]));

            while(!pq.isEmpty()){
                Node now = pq.poll();

                for(int i=0; i<4; i++){
                    int du = now.r+dr[i];
                    int dv = now.c+dc[i];
                    if(du<0 || dv<0 || du>=N || dv>=N) continue;

                    if(dist[du][dv]>dist[now.r][now.c]+map[du][dv]){
                        dist[du][dv] = dist[now.r][now.c]+map[du][dv];
                        pq.add(new Node(du, dv, dist[du][dv]));
                    }

                }
            }


            sb.append("Problem ").append(t).append(": ").append(dist[N-1][N-1]).append("\n");
            t++;


        }

        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        N =Integer.parseInt(br.readLine());
        map = new int[N][N];


        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
}