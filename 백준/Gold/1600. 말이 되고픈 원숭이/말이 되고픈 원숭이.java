import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = new int[] {-1,1,0,0}; //원숭이의 움직임
    static int[] dc = new int[] {0,0, -1,1}; //원숭이의 움직임

    static int[] hDr = new int[] {-2, -1, -2, -1, 1, 2, 1, 2}; //말 행 움직임
    static int[] hDc = new int[] {-1, -2, 1, 2, -2, -1, 2, 1}; //말 열 움직임

    static int K;
    static int W;
    static int H;
    static int min;

    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken()); //가로길이(열)
        H = Integer.parseInt(st.nextToken()); //세로길이(행)

        map = new int[H][W];
        visited = new int[K+2][H][W];



        min = Integer.MAX_VALUE;
        for(int h=0; h<H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w=0; w<W; w++){
                map[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);

        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }

    }


    static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>(); //0 : 행 / 1 : 열 / 2 : rank  / 3 : 그 당시 K

        queue.add(new int[] {r, c, 0, 0});
        visited[0][r][c] =1;
//        for(int k=0; k<K; k++){
//            visited[k][r][c] = 1;
//        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0]==H-1 && now[1]==W-1){
                min = Math.min(now[2], min);
                return;
            }


            //원숭이 이동
            for(int i=0; i<4; i++){
                int du = now[0] + dr[i];
                int dv = now[1] + dc[i];

                //map 범위 내인지 체크
                if(du>=0 && dv>=0 && du<H && dv<W && map[du][dv] ==0 && visited[now[3]][du][dv]==0 ){


                    queue.add(new int[] {du, dv, now[2]+1, now[3]});
                    
                    visited[now[3]][du][dv]=1;
//                    for(int k=0; k<=K; k++){
//                        visited[k][du][dv] =1;
//                    }


                }
            }

            //말처럼 이동할 횟수가 남았다면
            if(now[3]<K){
                for(int i=0; i<8; i++){
                    int du = now[0] + hDr[i];
                    int dv = now[1] + hDc[i];

                    if(du>=0 && dv>=0 && du<H && dv<W  && map[du][dv]==0 && visited[now[3]+1][du][dv]==0 ){
                        visited[now[3]+1][du][dv] ++;
                        queue.add(new int[] {du, dv, now[2]+1, now[3]+1});


                    }

                }

            }
        }


    }
}