import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int n, w, l;
    static int[] arr;
    static Queue<Integer> queue;
    static int cnt;
    static int sum;
    static int answer;

    public static void main(String[] args) throws IOException {

        input();

        sum = 0;
        cnt = 0;



        queue = new LinkedList<>();

        for(int i=0; i<w; i++){
            queue.add(0);
        }

        while(cnt<n){

            sum-= queue.poll();
            
            answer++;

            if(sum+arr[cnt]<=l){
                queue.add(arr[cnt]);
                sum+=arr[cnt];
                cnt++;
            }else{
                queue.add(0);
            }


        }


        while (!queue.isEmpty()) {
            queue.poll();
            answer++;
        }

        System.out.println(answer);


    }



    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}