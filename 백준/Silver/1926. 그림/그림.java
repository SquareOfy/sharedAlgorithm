import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};

    static int answer;

    static int area;

    public static void main(String[] args) throws IOException {

        input();
        int cnt =0;
        answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    area = 1;
                    cnt++;
                    dfs(i, j);
                    answer = Math.max(area, answer);
                }

            }
        }

        System.out.println(cnt);
        System.out.println(answer);
    }
    public static void dfs(int r, int c){
        visited[r][c] = true;

        for(int i=0; i<4; i++){
            int du = r + dr[i];
            int dv = c + dc[i];
            if(du<0 || dv<0 || du>=N ||dv>=M) continue;
            if(map[du][dv]==1 && !visited[du][dv]){
                dfs(du, dv);
                area++;
            }
        }

    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
    }
}