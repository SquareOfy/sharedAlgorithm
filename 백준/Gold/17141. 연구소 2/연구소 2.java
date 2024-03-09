import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> virusSpace;
    static boolean[] permVisited;
    static int[][] selected;
    static int[][] tmp;
    static int result;
    static int blank;

    public static void main(String[] args) throws IOException {

        input();
        result = Integer.MAX_VALUE;

        //selected에 M개의 바이러스 놓을 수 있는 위치 고르고 다 고르면 걸리는 시간 재기


        chooseSpace(0, 0);

        System.out.println(result==Integer.MAX_VALUE ? -1 : result);


    }


    public static void chooseSpace(int cnt, int idx){
        if(cnt==M){
            //bfs 돌려서 answer 갱신하기
            bfs();
            return;
        }

        for(int i=idx; i<virusSpace.size(); i++){
            if(!permVisited[i]){
               int[] now = virusSpace.get(i);
               selected[cnt][0] = now[0];
               selected[cnt][1] = now[1];
               permVisited[i] = true;
               chooseSpace(cnt+1, idx+1);
               permVisited[i] = false;
            }
        }

    }


    public static void bfs(){

        //바이러스를 퍼뜨릴 tmp 배열 & visited reset
        for(int i=0; i<N; i++) {
           tmp[i] = map[i].clone();
           Arrays.fill(visited[i], false);
        }


        int answer =0;
        Queue<int[]> queue = new LinkedList<>();
        //selected에 있는 자리 값을 0으로 바꾸고
        for(int i=0; i<M; i++){
            int r = selected[i][0];
            int c = selected[i][1];
            tmp[r][c] =0;
            visited[r][c] = true;

            queue.add(new int[] {r, c});

        }

        int cnt =0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();

            int r = now[0];
            int c = now[1];

            int time = tmp[r][c] +1;
            for(int i=0; i<4; i++){
                int du = r+dr[i];
                int dv = c+dc[i];

                if(du<0 || dv<0 || du>=N || dv>=N ) continue;

                if((tmp[du][dv] ==0||tmp[du][dv]==2) && !visited[du][dv]){
                    tmp[du][dv] = time;
                    visited[du][dv] = true;
                    answer = Math.max(answer, time);
                    queue.add(new int[]{du, dv});
                    cnt++;
                }
            }
        }



        if(cnt==blank) result = Math.min(result, answer);







    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map= new int[N][N];
        visited = new boolean[N][N];
        tmp = new int[N][N];



        virusSpace = new ArrayList<>();
        selected = new int[M][2];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<N; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m]==2){
                    virusSpace.add(new int[]{n,m});

                    blank++;
                }else if(map[n][m]==1) map[n][m] = -1;
                else blank++;
            }
        }

        blank -= M;

        permVisited = new boolean[virusSpace.size()];

    }
}