import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static int cnt;
    static boolean[] visited;
    static List<Integer> cycle;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {

        int idx = 0;
        while (true) {
            input();


            if (N == 0 && M == 0) {
                System.out.println(sb);
                return;
            }

            idx++;
            cnt = 0;
            cycle = new ArrayList<>();
            edges = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int n = 0; n <= N; n++) {
                edges[n] = new ArrayList<>();
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                edges[start].add(end);
                edges[end].add(start); //풀이 참고
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    cnt += checkTree(i);
                }
            }


            sb.append("Case ").append(idx).append(": ");
            if (cnt == 0) sb.append("No trees.").append("\n");
            else if (cnt == 1) sb.append("There is one tree.").append("\n");
            else sb.append("A forest of ").append(cnt).append(" trees.").append("\n");
        }

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    public static int checkTree(int root) {
        Queue<Integer> queue = new LinkedList<>();
        int node = 0;
        int edge = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[now]) continue;
            visited[now] = true;
            node++;

            for (int i = 0; i < edges[now].size(); i++) {
                edge++;
                int next = edges[now].get(i);
                if (!visited[next]) queue.add(next);
            }
        }

        return (edge / 2) + 1 == node ? 1 : 0;
    }
}