import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int R,C,T;
    static int[][] map;
    static int sum;
    static int[][] tmp;
    static int cleaner;

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        input();

        //T초 동안
        while(T>0){

            //미세먼지 확산

            //확산될 양 tmp 배열에 기록
            for(int r=1; r<=R; r++){
                for(int c=1; c<=C; c++){
                    if(map[r][c]==0 || map[r][c]==-1) continue;
                    //미세먼지 있으면
                    int dust = map[r][c];
                    int cnt =0;
                    int spread = dust/5;

                    for(int i=0; i<4; i++){
                        int du = r + dr[i];
                        int dv = c + dc[i];
                        //범위 벗어나면
                        if(du<=0 || dv<=0 || du>R || dv>C) continue;
                        if(dv ==1 &&(du==cleaner || du==cleaner+1)) continue; //공기청정기면 패스

                        tmp[du][dv]+= spread;
                        map[r][c] -= spread;
                        cnt ++;
                    }

                    sum -= spread * cnt;
                }
            }


            //tmp에 기록한 확산 양 map에 옮기기
            for(int r=1; r<=R; r++){
                for(int c=1; c<=C; c++){
                    if(tmp[r][c]!=0){
                        map[r][c]+= tmp[r][c];
                        sum += tmp[r][c];
                        tmp[r][c] = 0;
                    }
                }
            }

            //공기청정기 작동
            //나는 거꾸로 돌면서 한칸씩 공기청정기 쪽으로 땡길 것
            //공기청정기를 만나면 sum에서 빼고 없앨 것

//dir 상 좌 하 우 순

            //윗칸
            //나는 반대로 상 우 하 좌 순으로 갈 것.
            int dir = 0;
            int idxR = cleaner;
            int idxC = 1;
            while(true){

                int nextR = idxR+dr[dir];
                int nextC = idxC+dc[dir];


                //다음 칸이 범위를 넘어서면 방향 틀기
                if(nextR>R || nextC >C || nextR<1 || nextC <1 || (dir==2 && idxR==cleaner && idxC == C)){
                    dir += 3;
                    dir %= 4;
                    continue;
                }
                //현재 진행방향 다음칸을 보고 미세먼지 있으면 현재 칸으로 이동하기
                if(map[nextR][nextC]!=0&&map[nextR][nextC]!=-1){
                    if(map[idxR][idxC]!=-1) map[idxR][idxC] = map[nextR][nextC];
                    else {
                        sum -= map[nextR][nextC];
                    }
                    map[nextR][nextC] = 0; //옮긴 후 0으로
                }

                //idxR과 idxC 옮기기
                idxR = nextR;
                idxC = nextC;

                if(idxR==cleaner && idxC == 2) {
                    break;
                }
            }
//dir 상 좌 하 우 순


            //아래칸
            //하 우 상 좌

            dir = 2;
            idxR = cleaner+1;
            idxC = 1;
            while(true){

                int nextR = idxR+dr[dir];
                int nextC = idxC+dc[dir];

                //다음 칸이 범위를 넘어서면 방향 틀기
                if(nextR>R || nextC >C || nextR<1 || nextC <1 || (dir==0 && idxR==cleaner+1 && idxC == C)){
                    dir += 1;
                    dir %= 4;
                    continue;
                }
                //현재 진행방향 다음칸을 보고 미세먼지 있으면 현재 칸으로 이동하기
                if(map[nextR][nextC]!=0 && map[nextR][nextC] != -1){
                    if(map[idxR][idxC]!=-1) map[idxR][idxC] = map[nextR][nextC];
                    else {
                        sum -= map[nextR][nextC];
                    }
                    map[nextR][nextC] = 0; //옮긴 후 0으로
                }

                //idxR과 idxC 옮기기
                idxR = nextR;
                idxC = nextC;

                if(idxR==cleaner+1 && idxC == 2) break;
            }


            T--;




        }

        System.out.println(sum);


    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R+1][C+1];
        sum = 0;
        tmp = new int[R+1][C+1];
        for(int r=1; r<=R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());

                //공기청정기 위치 기억
                if(map[r][c]==-1){
                    if(cleaner==0)  cleaner = r;
                }else {
                    sum+= map[r][c];
                }
            }
        }
    }
}