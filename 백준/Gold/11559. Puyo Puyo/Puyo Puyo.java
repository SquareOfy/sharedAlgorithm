import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map;
    static int cnt;
    static boolean[][] visited;

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        input();


        int answer =0 ;
        boolean flag = true;
        while(flag){
            flag = false;
            //visited reset
            for(int i=0; i<12; i++){
                Arrays.fill(visited[i], false);
            }

            for(int i=11; i>=0; i--){
                for(int j=0; j<6; j++){
                    if(map[i][j]!=0&&!visited[i][j]){
                        cnt =0;
                        dfs(i, j, map[i][j]);
                        if(cnt>=4){
                            //0으로 만들기
                            makeZero(i, j, map[i][j]);
                            flag = true;
                        }

                    }
                }
            }

            if(!flag) break;
            answer ++;

            down();


        }

        System.out.println(answer);


    }

    public static void makeZero(int r, int c, int color){
        map[r][c] = 0;



        for(int i=0; i<4; i++){
            int du = r+dr[i];
            int dv = c+dc[i];

            if(du<0 || dv<0 || du>=12 || dv>=6 ) continue;


            if(visited[du][dv] && map[du][dv]==color){
                makeZero(du, dv, color);
            }


        }
    }



    public static void down(){
        for(int i=10; i>=0; i--){
            for(int j=0; j<6; j++){

                if(map[i][j]!=0 && map[i+1][j]==0){
                    int r = i;
                    while(r<11 && map[r+1][j]==0){
                        r++;
                    }

                    map[r][j] = map[i][j];
                    map[i][j] =0;
                }
            }
        }
    }


    public static void dfs(int r, int c, int color){
        cnt++;
        visited[r][c] = true;

        for(int i=0; i<4; i++){
            int du = r+dr[i];
            int dv = c+dc[i];

            if(du<0 || dv<0 || du>=12 || dv>=6 || visited[du][dv]) continue;

            if(map[du][dv]==color){
                dfs(du, dv, color);
            }


        }

    }

    public static void input() throws IOException {
        map = new int[12][6];
        visited = new boolean[12][6];
        for(int i=0; i<12; i++){
            String str = br.readLine();

            for(int j=0; j<6; j++){
                char c = str.charAt(j);
                if(c=='R') map[i][j] = 1; //R
                else if(c=='G') map[i][j] = 2; //G
                else if(c=='B') map[i][j] = 3; //B
                else if(c=='Y') map[i][j] = 4; //Y
                else if(c=='P') map[i][j] = 5;
            }
        }
    }
}