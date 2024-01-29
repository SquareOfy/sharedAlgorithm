import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};


    static int R;
    static int C;
    static int[][] map;
    static boolean[] visitedAlpha;
    static boolean[][] visited;

    static int max;
//    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

//        System.out.println((int)'A'); //65
//        System.out.println((int)'Z'); //90
        visitedAlpha = new boolean[26];
        visited = new boolean[R][C];
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        max = 0;


        for(int r=0 ;r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = (int)str.charAt(c)-65;
            }
        }




        dfs(0, 0, 1);


        System.out.println(max);
    }

    static void dfs(int r, int c, int cnt){

        visitedAlpha[map[r][c]]=true;

        for(int i=0; i<4; i++){
            int du = r+dr[i];
            int dv = c+dc[i];
            if(du<0 || dv<0 || du>=R || dv>=C) continue;

            if(!visitedAlpha[map[du][dv]]) {
                dfs(du, dv, cnt+1);
                max = Math.max(cnt, max);
            }
        }

        visitedAlpha[map[r][c]] = false;



        max=Math.max(cnt, max);
    }
}