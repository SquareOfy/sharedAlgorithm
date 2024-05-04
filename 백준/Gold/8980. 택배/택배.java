import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static class Node implements Comparable<Node>{
        int start;
        int end;
        int cnt;

        Node(int start, int end, int cnt){
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(Node o) {
            return this.end-o.end;
        }
    }

    static int N, C;
    static int M;
    static Node[] arr;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(arr);


        int[] truck = new int[N+1];
        int answer =0;


        for(int m=0; m<M; m++){

            int start = arr[m].start;
            int end = arr[m].end;
            int max =0;
            for(int i=start; i<end; i++){
                max = Math.max(truck[i], max);
            }

            int capacity = Math.min(arr[m].cnt, C-max);

            for(int i=start; i<end; i++){
                truck[i] += capacity;
            }

            answer+=capacity;

        }





        System.out.println(answer);
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        arr = new Node[M];

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            arr[m] = new Node(start,end, cnt);
        }

    }
}