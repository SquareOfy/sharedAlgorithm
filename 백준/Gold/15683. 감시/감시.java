import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int N,M;
    static int[][] map;

    static int blind ;
    static int answer;

    //cctv번호별로 direction index를 어디까지 봐야할 지 알려주는 배열
    static int[] idxArr = new int[]{0, 4, 2, 4, 4, 1};
    static int[][][] direction = {
        {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
        {{1,0,0,0},  {0,1,0,0}, {0,0,1,0}, {0,0,0,1}},
        {{1,0,1,0}, {0,1,0,1}, {0,0,0,0},{0,0,0,0}},
        {{1,1,0,0}, {1,0,0,1},{0,1,1,0}, {0,0,1,1}},
        {{1,1,1,0}, {1,1,0,1}, {1,0,1,1}, {0,1,1,1}},
        {{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}}};


    static int[] dr = new int[] {1,0,-1,0};
    static int[] dc = new int[] {0,-1,0,1};


    static List<int[]> cctvList;


    public static void main(String[] args) throws IOException {

        blind =0;
        cctvList = new LinkedList<>();
        input();
        answer = blind;

        deleteBlind(0);

        System.out.println(answer);


        //재귀 ?

        //map을 다 돌며 cctv가 발견되는 경우
        //그 cctv번호의 direction index의 2차원 배열 보기.
        //각 배열의 행을 돌며 열 값이 0이 아니면 그 열 번호의 dr,dc 방향으로 사각지대면(!=-1) 제거(-1 표기)
        //가는 방향이 index넘어가거나 벽을 만나면(==6) stop
        //모든 cctv를 보고나서 사각지대 개수 최솟값 갱신 ...



    }

    //i번째 cctv로 사각지대 제거하기
    public static void deleteBlind(int idx){
        //마지막 cctv까지 다 본 경우 사각지대 개수 cnt 해서 최솟값으로 갱신
        if(idx==cctvList.size()){
            int cnt =0;

            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(map[n][m]<0) cnt++;

                    ;
                }
            }
            answer = Math.min(answer , blind-cnt);

            return;
        }

        //cctv 좌표
        int[] cctvCoord = cctvList.get(idx);


        int cctv = map[cctvCoord[0]][cctvCoord[1]];

        //direction을 이만큼만 돌꺼다. cctv가 보는 방향 수만큼만
        for(int i=0; i<idxArr[cctv]; i++){
            //4방향 확인하기
            int du = cctvCoord[0];
            int dv = cctvCoord[1];

            for(int j=0; j<4; j++){
                //cctv가 보는 방향이라면
                //현위치

                if(direction[cctv][i][j] == 1){
                    du = cctvCoord[0];
                    dv = cctvCoord[1];
                    while(true){

                        du += dr[j];
                        dv += dc[j];

                        //범위 벗어나면
                        if(du <0 || du>=N || dv<0 || dv>=M) break;
                        //벽 만나면
                        if(map[du][dv]==6) break;
                        //다 아니면 사각지대 제거
                        if(map[du][dv] <=0) map[du][dv] --;
                    }

                }
            }


            //4방향 중 cctv가 보는 방향 다 사각지대 제거 후 재귀 호출
            deleteBlind(idx+1);
            //재귀 호출 후 cctv 사각지대 되돌리기

            for(int j=0; j<4; j++){
                if(direction[cctv][i][j]==1){
                    du = cctvCoord[0];
                    dv = cctvCoord[1];
                    //가던 방향 반대로

                    while(true){


                        du += dr[j];
                        dv+= dc[j];
                        if(du <0 || du>=N || dv<0 || dv>=M) break;
                        //벽 만나면
                        if(map[du][dv]==6) break;
                        //원래 cctv위치 만나는 순간 끝내기
                        if(map[du][dv] <0) map[du][dv] ++;
                    }

                }

            }

        }

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map= new int[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){;
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m] ==0) blind ++;
                else if(map[n][m] != 6) cctvList.add(new int[] {n,m});
            }
        }


    }
}