import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int N,M, cheese;
    static int[][] map;

    static int[] dr = new int[] {-1,0,1,0};
    static int[] dc = new int[] {0,-1,0,1};

    public static void main(String[] args) throws IOException {

        int time =0 ;


        input();


        //외부 공기 변별 (2) by dfs
        //(1,1)좌표부터 dfs 시작
        dfs(1,1);


        Queue<int[]> queue = new LinkedList<>();
        //아래반복

        while(cheese>0) {
            //time 증가시키고(1시간 지남)
            time++;
            //map 전체를 돌며 cheese 네 면 확인하여 녹을 치즈 골라 2로 만들기)
            for(int n=1; n<=N; n++){
                for(int m=1; m<=M; m++){
                    //치즈라면
                    if(map[n][m]==1){
                        int outair =0;
                        int innerAir = 0;
                        //네 면 확인하여 외부 공기 수 체크
                        for(int i=0; i<4; i++){
                            int du = n+dr[i];
                            int dv = m+dc[i];

                            if(du<=0 || dv<=0 || du>N || dv>M) continue;
                            if(map[du][dv]==2) outair ++;
                            //안쪽 공기와 맞닿아 있다면 flag
                            else if(map[du][dv]==0){
                                innerAir =1;
                            }
                        }

                        if(outair>=2) {
                            //녹을 치즈를 모아두는 queue에 넣기
                            queue.add(new int[]{n,m, innerAir});

                        }


                    }
                }
            }

            //녹일 치즈 꺼내서 녹이고 필요할 경우 dfs
            while(!queue.isEmpty()){
                int[] now = queue.poll();

                map[now[0]][now[1]]=2;
                cheese--;
                if(now[2]==1) dfs(now[0], now[1]);
            }





        }
        System.out.println(time);


    }

    public static void dfs(int r, int c){
        map[r][c]=2;

        for(int i=0; i<4; i++){
            int du = r+dr[i];
            int dv = c+dc[i];
            if(du<=0 || dv<=0 || du>N || dv>M) continue;
            if(map[du][dv]==0) dfs(du, dv);
        }
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+2][M+2];

        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=1; m<=M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m]==1) cheese++;
            }
        }
    }
}
