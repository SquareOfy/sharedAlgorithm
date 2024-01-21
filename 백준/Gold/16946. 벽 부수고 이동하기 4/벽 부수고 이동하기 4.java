import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};


    static Node[][] result;

    public static class Node {
        int cnt;
        int num;

        public Node(int cnt, int num) {
            this.cnt = cnt;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        result = new Node[N][M];


        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m) - '0';
                result[n][m] = new Node(0,0);

            }
        }

        int num = 2;
        for (int i = 0; i < N; i++) {
            for(int j=0; j<M; j++){
                if(map[i][j]==0 && !visited[i][j]){
                    bfs(new int[] {i, j}, num++);
                }
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) sb.append(count(i, j));
                else sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

    public static int count(int r, int c) {
        HashSet<Integer> set = new HashSet<>();

        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int du = r + dr[i];
            int dv = c + dc[i];

            if (du < 0 || du >= N || dv < 0 || dv >= M) continue;


            if (map[du][dv] == 0 && !set.contains(result[du][dv].num)) {
                cnt += result[du][dv].cnt;
                set.add(result[du][dv].num);
            }
        }

        return cnt % 10;
    }

    public static void bfs(int[] arr, int num) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> tmp = new LinkedList<>();

        queue.add(arr);
        tmp.add(arr);

        int cnt = 1;
        visited[arr[0]][arr[1]] = true;


        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int du = now[0] + dr[i];
                int dv = now[1] + dc[i];

                if (du >= 0 && du < N && dv >= 0 && dv < M && map[du][dv] == 0 && !visited[du][dv]) {
                    cnt++;
                    queue.add(new int[]{du, dv});
                    tmp.add(new int[]{du, dv});
                    visited[du][dv] = true;


                }
            }
        }

        while (!tmp.isEmpty()) {
            int[] now = tmp.poll();

            result[now[0]][now[1]].cnt = cnt;
            result[now[0]][now[1]].num = num;

        }

    }

}