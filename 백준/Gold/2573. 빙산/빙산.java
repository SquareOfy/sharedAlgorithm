import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int r;
        int c;
        int melt;

        Node(int r, int c, int melt){
            this.r = r;
            this.c = c;
            this.melt = melt;
        }
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[][] map;


    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        input();

        //1. Queue에 빙하인 곳 다 넣기
        Queue<Node> queue = new LinkedList<>();



        //2. 바깥 while문에서 dfs로 빙하 덩어리 개수 체크하고 2개면 answer sout 후 return

        int time =0;
        while(true){

            //3. 빙하덩어리가 1개면 Queue에 빙하와 주변에 접하는 바다 개수 넣기
            //빙하 개수 체크
            int cnt =0;
            boolean[][] dfsVisited = new boolean[N][M]; //
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(!dfsVisited[n][m] && map[n][m]!=0){
                        dfsVisited[n][m] = true;
                        dfs(n, m, dfsVisited);
                        cnt++;
                    }
                }
            }

            if(cnt>=2) {
                System.out.println(time);
                return;
            }
            if(cnt==0) {
                System.out.println(0);
                return;
            }

            //빙하인 곳 queue에 넣기
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(map[n][m]!=0){
                        int melt = 0;
                        //주변에 접한 바다 개수 세기
                        for(int i=0; i<4; i++){
                            int du = n+dr[i];
                            int dv = m+dc[i];
                            if(du<0||dv<0||du>=N||dv>=M||map[du][dv]>0) continue;
                            melt++;
                        }
                        queue.add(new Node(n, m, melt));
                    }
                }
            }
            //4.  Queue에 있는 값을 다 꺼내면서 바다가 된다면 바다 만들기 ..?
            while(!queue.isEmpty()){
                Node ice = queue.poll();
                map[ice.r][ice.c] = Math.max(map[ice.r][ice.c]- ice.melt, 0);
            }
            time ++;



        }





    }

    public static void dfs(int r, int c, boolean[][] visited){

        for(int i=0; i<4; i++){
            int du = r + dr[i];
            int dv = c + dc[i];

            if(du<0 || dv<0 || du>=N || dv>=M || visited[du][dv] || map[du][dv]==0) continue;
            visited[du][dv] = true;
            dfs(du, dv, visited);
        }

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
    }
}