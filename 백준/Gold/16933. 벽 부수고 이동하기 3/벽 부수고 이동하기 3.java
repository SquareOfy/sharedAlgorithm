import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M,K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,-1,0,1};

    public static void main(String[] args) throws IOException {

        input();

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0, 1, 0, true));
        visited[0][0][0] = true;

        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.r==N-1 && now.c==M-1) {
                answer = Math.min(answer, now.rank);
                continue;
            }

            //밤낮 바뀜
            boolean isDay = now.isDay;

            for(int i=0; i<4; i++){
                int du = now.r+dr[i];
                int dv = now.c+dc[i];

                if(du<0||dv<0||du>=N||dv>=M) continue;

                //0이고 현재 rank에서 이동한 적이 없는 곳이면 이동하기
                if(map[du][dv]==0 && !visited[du][dv][now.times]){
                    queue.add(new Node(du, dv, now.rank+1, now.times, !isDay));
                    visited[du][dv][now.times] = true;
                }

                //1이지만 벽 부술 횟수가 남았고 방문하지 않은 곳일 때
                if(map[du][dv]==1 && now.times<K && !visited[du][dv][now.times]){
                    if(isDay) {
                        queue.add(new Node(du, dv, now.rank+1, now.times+1, !isDay));
                        visited[du][dv][now.times]=true;
                    }else{
                        queue.add(new Node(now.r, now.c, now.rank+1, now.times, !isDay));
                    }
                }
            }


        }
        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);

    }

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K+1];

        for(int n=0; n<N; n++){
            String str = br.readLine();
            for(int m=0; m<M; m++){
                map[n][m] = str.charAt(m)-'0';
            }
        }

    }

    static class Node{
        int r;
        int c;
        int rank;
        int times;
        boolean isDay;

        Node(int r, int c, int rank, int times, boolean isDay){
            this.r = r;
            this.c = c;
            this.rank = rank;
            this.times = times;
            this.isDay = isDay;
        }
    }
}