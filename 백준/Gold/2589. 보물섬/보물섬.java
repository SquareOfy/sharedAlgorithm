import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0,0, -1, 1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        LinkedList<int[]> list = new LinkedList<>();

        for(int n=0; n<N; n++){
            String str = br.readLine();
            for(int m=0; m<M; m++){
                if(str.charAt(m) =='L' ){
                    map[n][m] = 1;
                    list.add(new int[] {n, m, 0});
                }
            }
        }

        int S = list.size();
        int result = 0;

        for(int s=0; s<S; s++){
            int d = bfs(list.get(s));

           result = Math.max(result,d);

        }

        System.out.println(result);



    }


    public static int bfs(int[] o1){
        Queue<int[]> queue = new LinkedList<>();

        visited = new boolean[N][M];
        queue.add(o1);
        visited[o1[0]][o1[1]] = true;

        int result =0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            result = Math.max(now[2], result);
            for(int i=0; i<4; i++){
                int du = now[0]+dr[i];
                int dv = now[1]+dc[i];
                if(du<0 || du>=N || dv<0 || dv>=M || visited[du][dv] || map[du][dv]==0) continue;

                queue.add(new int[] {du, dv, now[2]+1});
                visited[du][dv] = true;
            }
        }

        return result;


    }

}