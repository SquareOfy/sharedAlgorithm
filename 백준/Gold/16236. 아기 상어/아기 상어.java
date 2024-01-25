import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};


    static int size;
    static int time;
    static int cnt;

    static int answer;
    static ArrayList<Node> queue = new ArrayList<>();

    public static class Node implements Comparable<Node> {
        int r;
        int c;


        public Node(int r, int c) {
            this.r = r;
            this.c = c;

        }


        @Override
        public int compareTo(Node o) {
            if(this.r != o.r){
                return this.r - o.r;
            }
            else {
                return this.c - o.c;
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;


        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        time = 0;
        size = 2;
        cnt = 0;

        Node start = new Node(-1, -1);

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < N; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
                if (map[n][m] == 9) {
                    start = new Node(n, m);
                    map[n][m] = 0;
                }
            }
        }

        bfs(start);


    }



    public static void bfs(Node node) {


        queue.add(node);
        boolean flag = false;

        while (!queue.isEmpty()) {

            Collections.sort(queue);
            int qSize = queue.size();

            for (int s = 0; s < qSize; s++) {
                Node now = queue.remove(0);




                int fishSize = map[now.r][now.c];
                if (fishSize > 0 && fishSize < size) {
                    map[now.r][now.c] = 0; // 먹음
                    cnt++; // cnt 증가
                    if (cnt == size) {
                        size++;
                        cnt = 0;
                    }





                    //먹이를 먹었으므로 이동한 것임
                    queue.clear();
                    visited = new boolean[N][N];
                    visited[now.r][now.c] = true;

                    answer = time;

                    flag = true;

                }
                //now에서 이동
                for (int i = 0; i < 4; i++) {
                    int du = now.r + dr[i];
                    int dv = now.c + dc[i];



                    if (du < 0 || dv < 0 || du >= N || dv >= N) continue;

                    if (!visited[du][dv] && map[du][dv] <= size) {
                        queue.add(new Node(du, dv));
                        visited[du][dv] = true;
                    }
                }

                if (flag) {
                    flag = false;
                    break;
                }


            }

            time++;



        }
        System.out.println(answer);

    }
}