import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        //행, 열, 사다리 또는 뱀 여부, 이동 칸 값
        map = new int[10][10][2];
        visited = new boolean[10][10];
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken());

            map[x / 10][(x) % 10 ][0] = 1; //사다리
            map[x / 10][(x) % 10 ][1] = y;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());

            map[u / 10][(u) % 10 ][0] = 2; //뱀
            map[u / 10][(u) % 10 ][1] = v;
        }


        int rank = bfs();
        System.out.println(rank);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

//        int now = 1;
        queue.add(new int[]{1, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            if (tmp[0] == 100) return tmp[1];
            for (int n = 1; n <= 6; n++) {
                int next = tmp[0] + n;

                int du = (next-1)/10;
                int dv = (next-1) % 10;

                if (next <= 100 && !visited[du][dv]) {
                    if (map[du][dv][0] == 0) {
                        queue.add(new int[]{next, tmp[1] + 1});
                        visited[du][dv] = true;
                    } else if (map[du][dv][0] == 1) {
                        queue.add(new int[]{map[du][dv][1], tmp[1] + 1});
                        int ladder = map[du][dv][1] - 1;
                        visited[du][dv] = true;

//                        visited[ladder / 10][(ladder) % 10] = true;


                    }else if(map[du][dv][0]==2){
                        queue.add(new int[]{map[du][dv][1], tmp[1]+1});
                        visited[du][dv] = true;

                    }

                }
            }
        }
        return -1;
    }


}