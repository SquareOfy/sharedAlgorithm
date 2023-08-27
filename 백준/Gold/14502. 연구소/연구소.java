
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;

    static int N;
    static int M;
    static int max;

    static boolean[][] visited;
    static boolean[][] visitedBFS;
    static int virusCnt = 0;
    static int zeroCnt = -3;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        visitedBFS = new boolean[N][M];
        virusCnt = 0;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
                if (map[n][m] == 0) zeroCnt++;
            }
        }

        max = 0;


        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (map[n][m] == 0) {
                    makeWall(0, n, m);

                }
            }
        }

        System.out.println(max);


    }


    public static void makeWall(int cnt, int r, int c) {

        if (cnt == 3) {
            //벽 세울 세자리 다 고른 후, 남은 자리 카운트

            bfs();
            max = Math.max(zeroCnt - virusCnt, max);

            return;
        }

        for (int n = r; n < N; n++) {
            for (int m = 0; m < M; m++) {

                if (map[n][m] == 0) {

                    map[n][m] = 1; //벽 세우기

                    makeWall(cnt + 1, n, m);//다음 벽 세우러 가기
                    map[n][m] = 0; //벽 원상복귀
                }
            }
        }
    }

    public static void bfs() {
        //cnt 리셋하고 시작
        virusCnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (map[n][m] == 2) {
                    queue.add(new int[]{n, m});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (!visitedBFS[nr][nc] && map[nr][nc] == 0) {
                    virusCnt++;
                    visitedBFS[nr][nc] = true; //방문처리
                    queue.add(new int[]{nr, nc});
                }


            }
        }//while 종료
        for (int i = 0; i < N; i++) {
            Arrays.fill(visitedBFS[i], false);
        }
    }//bfs종료

}
