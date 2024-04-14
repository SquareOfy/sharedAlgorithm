import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[] lecture;


    public static void main(String[] args) throws IOException {

        input();

        long max = (long) Math.ceil( (double) 10000 * N / (double)M );

        long answer = binary_search(0, max);

        System.out.println(answer);






    }

    public static long  binary_search(long left, long right){

        long mid = 0;

        while(left<right){
            mid = (left+right)/2;

            int cnt = countBluray(mid);

            if(cnt>M){
                left = mid+1;
            }else{
                right=mid;
            }
        }

        return right;

    }

    public static int countBluray(long mid){
        int cnt =1;
        int capacity =0;
        for(int i=0; i<N; i++){
            if(lecture[i]>mid){
                return M+1;
            }
            if(capacity+lecture[i] <= mid){
                capacity += lecture[i];
            }else{
                capacity = lecture[i];
                cnt++;
            }
        }
        return cnt;
    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        lecture = new int[N];
        for(int n=0; n<N; n++){
            lecture[n] = Integer.parseInt(st.nextToken());
        }
    }
}