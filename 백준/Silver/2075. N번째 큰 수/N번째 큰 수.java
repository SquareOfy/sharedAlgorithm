import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {

        input();


        System.out.println(pq.poll());




    }


    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        pq = new PriorityQueue<>();
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){

                pq.add(Integer.parseInt(st.nextToken()));
                if(pq.size()>N) {
                    pq.poll();
                }
            }
        }
    }
}