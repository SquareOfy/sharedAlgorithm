import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] start = new int[3];
        boolean[][] visited = new boolean[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m] ==2) {
                    start[0] = n;
                    start[1] = m;
                }
            }

        }


        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;
        map[start[0]][start[1]] =0;
        int[] dr = new int[] {-1,0,1,0};
        int[] dc = new int[] {0, -1, 0, 1};
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++){
                int du = tmp[0] +dr[i];
                int dv = tmp[1] +dc[i];
                if(du<0 || dv<0 || du>=N || dv>=M){
                    continue;
                }

                if(!visited[du][dv] && map[du][dv]==1){
                    queue.add(new int[]{du, dv, tmp[2]+1});
                    map[du][dv] = tmp[2]+1;
                    visited[du][dv]=true;
                }
            }

        }

        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(visited[n][m] || map[n][m] ==0) sb.append(map[n][m]).append(" ");
                else{
                    sb.append(-1).append(" ");
                }
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());



    }
}