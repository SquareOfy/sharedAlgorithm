import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;

    static int[] arr;

    public static void main(String[] args) throws IOException {

        input();
        LinkedList<Integer> deque = new LinkedList<>();
        for(int n=1; n<=N; n++){
            deque.offer(n);
        }

        int cnt =0;
        for(int m=0; m<M; m++){
            int target = deque.indexOf(arr[m]);

            int mid = deque.size()/2;
            if(deque.size()%2==0) mid--;

            if(target<=mid){
                for(int j=0; j<target; j++){
                    cnt ++;
                    int tmp = deque.pollFirst();
                    deque.offerLast(tmp);
                }
            }else{
                for(int j=0; j<deque.size()-target; j++){
                    cnt ++;
                    int tmp = deque.pollLast();
                    deque.offerFirst(tmp);
                }
            }
            deque.pollFirst();
        }

        System.out.println(cnt);

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            arr[m] = Integer.parseInt(st.nextToken());
        }

    }
}