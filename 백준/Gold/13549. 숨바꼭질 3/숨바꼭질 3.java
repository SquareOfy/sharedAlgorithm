import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;

    public static class Node {
        int point;
        int time;

        public Node(int n, int time) {
            this.point = n;
            this.time = time;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        int result = bfs(N, K);
        System.out.println(result);
    }

    public static int bfs(int n, int K) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(n, 0));
        visited[n] = true;


        while (!queue.isEmpty()) {
            Node now = queue.poll();

            //동생 잡음
            if (now.point == K) {
                return now.time;
            }
            int fast = now.point * 2;
            while (fast > 0 && fast <= 100000) {
                if (!visited[fast]) {
                    queue.add(new Node(fast, now.time));
                    visited[n] = true;
                }

                fast *= 2;
            }

            int frontWalk = now.point + 1;
            int backWalk = now.point - 1;

            if (backWalk >= 0 && backWalk <= 100000 && !visited[backWalk]) {
                queue.add(new Node(backWalk, now.time + 1));
                visited[backWalk] = true;
            }


            if (frontWalk >= 0 && frontWalk <= 100000 && !visited[frontWalk]) {
                queue.add(new Node(frontWalk, now.time + 1));
                visited[frontWalk] = true;
            }

        }


        return -1;


    }


}