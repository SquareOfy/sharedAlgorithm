import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M,N;
    static int[] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        input();

        int left = 1;
        int right =max;

        int answer =0;
        while(left<=right){
            int mid = (left+right)/2;

            int cnt =0;

            for(int i=0; i<N; i++){
                cnt += arr[i]/mid;
            }

            if(cnt >=M) {
                answer = mid;

                left = mid+1;
            }else{
                right = mid-1;
            }

        }

        System.out.println(answer);


    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n]=Integer.parseInt(st.nextToken());
            if(arr[n]>max) max = arr[n];
        }
    }
}