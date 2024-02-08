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
    static List<Integer> cycle;

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
            List<Integer>[] edges = new ArrayList[N + 1];
            boolean[] visited = new boolean[N + 1];

            for (int n = 0; n <= N; n++) {
                edges[n] = new ArrayList<>();
            }
            int[] p = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                p[i] = i;
            }


            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                union(p, start, end);
            }


            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {

                int pi = findParents(p, i);
                if(pi>0){
                    set.add(pi);
                }
            }
            cnt = set.size();


//            for (int i = 1; i <= N; i++) {
//                //사이클 확인
//                if (cycle.contains(findParents(p, i)) || visited[p[i]]) continue;
//                int edgesCnt = edges[i].size();
//                int nodeCnt = 1;
//                visited[p[i]] = true;
//                for (int j = i + 1; j <= N; j++) {
//                    if (p[i] == p[j]) {
//                        nodeCnt++;
//                        edgesCnt += edges[j].size();
//                    }
//
//                }


//                System.out.println(" i : "+ i);
//                System.out.println("node : " + nodeCnt);
//
//                System.out.println("edges : " + edgesCnt);
//                if (nodeCnt - edgesCnt / 2 == 1) cnt++;

//            }


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

    public static void union(int[] p, int x, int y) {

        if (x == y) {
            cycle.add(x);
            return;
        }
        int px = findParents(p, x);
        int py = findParents(p, y);


        if (px == py) {
            p[px] = 0;
            return;
        }
        if (px < py) p[py] = p[px];
        else p[px] = p[py];

    }


    public static int findParents(int[] p, int x) {
        if (p[x] == x) return x;
        p[x] = findParents(p, p[x]);
        return p[x];
    }

}