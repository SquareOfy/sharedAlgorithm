import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        input();


        long answer = binary_search();
        System.out.println(answer);
    }

    public static long binary_search(){
        long start = 0;
        long end = Integer.MAX_VALUE;

        while(start+1<end){
            long mid = (start+end+1)/2;

            if(check(mid)>=K){
                start = mid;
            }else{
                end = mid;
            }

        }

        return start;
    }

    public static long check(long mid){
        long cnt=0;
        for(int i=0; i<N; i++){
            cnt+= arr[i]/mid;
        }

        return cnt;
    }

    public static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }
    }
}