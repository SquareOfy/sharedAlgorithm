import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dr = new int[] {-1,1,0,0};
    static int[] dc = new int[] {0,0,-1,1};

    static int T;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        T= Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if(result==-1) System.out.println("Fail");
        else System.out.println(result);

    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0 , 0, false));
        visited[0][0][0] = true;


        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.rank>T) return -1;
            if(now.r == N-1 && now.c ==M-1){
                return now.rank;
            }

            for(int i=0; i<4; i++){
                int du = now.r +dr[i];
                int dv = now.c + dc[i];

                if(du<0 || du>=N || dv<0 || dv>=M ) continue;
                if(!now.flag && map[du][dv]==1){
                    continue;
                }


                if(!now.flag && !visited[0][du][dv] ){
                    if(map[du][dv]==0) {
                        queue.add(new Node(du, dv, now.rank+1, now.flag));
                        visited[0][du][dv] = true;
                    }else if(map[du][dv]==2){
                       queue.add(new Node(du, dv, now.rank+1, true));

                       visited[1][du][dv] = true;
                    }

                }else if(now.flag && !visited[1][du][dv]){
                    queue.add(new Node(du, dv, now.rank+1, now.flag));
                    visited[1][du][dv] = true;
                }
            }

        }

        return -1;

    }

    public static class Node{
        int r;
        int c;
        int rank;
        boolean flag;

        public Node(int r, int c, int rank, boolean flag){
            this.r = r;
            this.c = c;
            this.rank = rank;
            this.flag = flag;
        }
    }
}