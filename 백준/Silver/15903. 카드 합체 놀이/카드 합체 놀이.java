import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add((long) arr[i]);
        }

        for(int m=0; m<M; m++){
            long x = pq.poll();
            long y = pq.poll();
            long num  = x+y;

            pq.add(num);
            pq.add(num);
        }

        long answer =0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);

    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
    }
}