import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    static class Node {
        int r;
        int c;
        int rank;
        int key;

        Node(int r, int c, int rank, int key) {
            this.r = r;
            this.c = c;
            this.rank = rank;
            this.key = key;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;


    static Node start;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        input();


        int answer = Integer.MAX_VALUE;


        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.r][start.c][0] = true;

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        while (!queue.isEmpty()) {
            Node now = queue.poll();



            if (map[now.r][now.c] == 1) {
                answer = now.rank;
                break;
                //종료?
            }

            for (int i = 0; i < 4; i++) {
                int du = now.r + dr[i];
                int dv = now.c + dc[i];


                //미로 범위 벗어나거나 벽이면 넘어가기
                if (du < 0 || du >= N || dv < 0 || dv >= M || map[du][dv] == -1 || visited[du][dv][now.key]) continue;

                //방문하지 않았을 때
                //빈칸이면 queue 에 그냥 넣기
                if (map[du][dv] == 0 || map[du][dv] == 1) {
                    visited[du][dv][now.key] = true;
                    queue.add(new Node(du, dv, now.rank + 1, now.key));
                } else if (map[du][dv] <= -2) { //열쇠이면
                    int num = Math.abs(map[du][dv]);
                    //열쇠 주워서 그 열쇠 자리 비트마스크 변경
                    int key = now.key | (1 << (num - 2));
                    visited[du][dv][key] = true;
                    queue.add(new Node(du, dv, now.rank + 1, key));
                } else if (map[du][dv] >= 2) { //문이면
                    //열쇠 있는지 확인하고 있으면 이동
                    if ((now.key & 1 << (map[du][dv] - 2)) == (1 << (map[du][dv] - 2))) {
                        visited[du][dv][now.key] = true;
                        queue.add(new Node(du, dv, now.rank + 1, now.key));
                    }
                }


            }

        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][64];

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {

                char c = str.charAt(m);

                if (c == '#') map[n][m] = -1;    //벽은 -1
                else if (c == '1') map[n][m] = 1; //도착지는 1
                else if (c == '0') start = new Node(n, m, 0, 0); //출발지 저장
                else if ((int) c >= 97 && (int) c <= 102) {
                    map[n][m] = -1 * ((int) c - 95);    //열쇠는 음수 -2, -3, -4, -5, -6, -7
                } else if ((int) c >= 65 && (int) c <= 70) {
                    map[n][m] = (int) c - 63;  //문은 열쇠와 절댓값이 같은 양수
                }

            }
        }


    }
}