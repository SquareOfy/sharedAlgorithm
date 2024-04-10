import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[][] jewel;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Arrays.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        long money = 0;

        for (int i = 0; i < K; i++) {
            while (idx < N && bag[i] >= jewel[idx][0]) {
                pq.add(jewel[idx][1]);
                idx++;

            }
            if (!pq.isEmpty()) {
                money += pq.poll();
            }

        }


        System.out.println(money);

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewel = new int[N][2];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            jewel[n][0] = Integer.parseInt(st.nextToken());
            jewel[n][1] = Integer.parseInt(st.nextToken());
        }

        bag = new int[K];
        for (int k = 0; k < K; k++) {
            bag[k] = Integer.parseInt(br.readLine());
        }

    }
}