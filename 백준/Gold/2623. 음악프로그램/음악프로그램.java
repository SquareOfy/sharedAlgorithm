import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] degree;
    static ArrayList<Integer>[] list;
    static boolean flag;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        input();

//        System.out.println(Arrays.toString(degree));

        int cnt =0;
        Queue<Integer> queue = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            if (degree[n] == 0) {
                queue.add(n);
                visited[n] = true;
                flag = true;
            }
        }

       outer: while (!queue.isEmpty()) {
            int now = queue.poll();
//            System.out.println("now : " + now);
//            System.out.println("visited ");
//            System.out.println(Arrays.toString(visited));
            sb.append(now).append("\n");
            cnt ++;

            for (int next : list[now]) {
//                System.out.println("next : "+ next);
                if (visited[next]) {
                    flag = false;
                    break outer;
                }
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }


        if (cnt<N) System.out.println(0);
        else System.out.println(sb.toString());

    }



    public static void input() throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        flag = false;
        degree = new int[N + 1];
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int n = 0; n <= N; n++) {
            list[n] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            int before = 0;
            while (st.hasMoreTokens()) {
                int now = Integer.parseInt(st.nextToken());
                if(before!=0){
                    list[before].add(now);
                    degree[now]++;
                }

                before = now;
            }
        }


    }
}