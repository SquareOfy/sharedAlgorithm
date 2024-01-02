import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = new int[] {-1,1, 0,0,-1,-1,1,1};  //상,하,좌,우,좌상,우상,좌하,우하
    static int[] dc = new int[] {0,0,-1, 1, -1, 1, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Shark> queue = new LinkedList<>();
        int dist = Integer.MIN_VALUE;
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m]  = Integer.parseInt(st.nextToken());
                if(map[n][m]==1) {
                    queue.add(new Shark(n,m,0));
                    visited[n][m] = true;
                }

            }
        }


        while(!queue.isEmpty()){
            Shark shark = queue.poll();

            dist = Math.max(shark.rank, dist);
            for(int i=0; i<8; i++){
                int du = shark.r + dr[i];
                int dv = shark.c + dc[i];

                if(du>=0 && du<N && dv>=0 && dv<M && !visited[du][dv] ){
                    visited[du][dv] = true;
                    queue.add(new Shark(du, dv, shark.rank+1));
                }
            }


        }

        System.out.println(dist);
    }

    public static class Shark{
        int r;
        int c;
        int rank;

        public Shark(int r, int c, int rank){
            this.r = r;
            this.c = c;
            this.rank = rank;
        }
    }
}