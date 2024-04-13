import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static Node[] arr;
    public static void main(String[] args) throws IOException {

        input();

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(arr[0].end);

        for(int i=1; i<N; i++){
            if(arr[i].start < pq.peek()){
                pq.add(arr[i].end);
            }else{
                pq.poll();
                pq.add(arr[i].end);
            }
        }

        System.out.println(pq.size());





    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        for(int n = 0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[n] = new Node(start, end);
        }
    }

    public static class Node implements Comparable<Node> {
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o) {
            if(this.start==o.start) return this.end-o.end;
            return this.start-o.start;
        }
    }
}