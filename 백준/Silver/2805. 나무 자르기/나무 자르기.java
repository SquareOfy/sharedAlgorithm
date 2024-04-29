import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int answer = binary_search();

        System.out.println(answer);
    }

    public static int binary_search(){
        int start = 0 ;
        int end = Arrays.stream(arr).max().getAsInt();

        while(start + 1 < end){
            int mid = (start + end)/2;
            if(check(mid)) start = mid;
            else end = mid;
        }

        return start;
    }

    public static boolean check(int mid){
        long sum =0;
        for(int i=0; i<N; i++){
            if(arr[i]>mid) sum+= arr[i]-mid;
        }

        return sum>=M;
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