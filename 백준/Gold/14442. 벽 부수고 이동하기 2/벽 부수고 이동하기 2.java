import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;

    static int answer;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};

    public static class Node {
        int r;
        int c;
        int cnt; //벽 부순 횟수
        int rank;

        Node(int r, int c, int cnt, int rank) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        answer = Integer.MAX_VALUE;
        bfs(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, 0, 1));
        visited[0][r][c] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.r == N - 1 && now.c == M - 1) {
                answer = Math.min(now.rank, answer);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int du = now.r + dr[i];
                int dv = now.c + dc[i];

                if (du < 0 || dv < 0 || du >= N || dv >= M) continue;


                if (map[du][dv] == 0 && !visited[now.cnt][du][dv]) {
                    visited[now.cnt][du][dv] = true;
                    queue.add(new Node(du, dv, now.cnt, now.rank + 1));
                } else if (now.cnt < K && map[du][dv] == 1 && !visited[now.cnt + 1][du][dv]) {
                    //벽 부술 기회가 남아 있다면 부숴보기
                    visited[now.cnt + 1][du][dv] = true;
                    queue.add(new Node(du, dv, now.cnt + 1, now.rank + 1));

                }
            }
        }
    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        visited = new boolean[K + 1][N][M];

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m) - '0';
            }
        }
    }
}