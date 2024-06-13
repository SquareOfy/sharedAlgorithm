import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        input();

        int start = 0;
        int end = N;
        int mid  = 0;

        int answer = 0;
        while(start<=end){
            mid = (start+end+1)/2;
            
            if(check(mid)){
                end = mid-1;
                answer = mid;

            }else{
                start = mid+1;

            }
        }

        System.out.println(answer);



    }

    static boolean check(int mid){
        boolean[] isBright = new boolean[N];

        for(int m=0; m<M; m++){
            int left = Math.max(0, arr[m]-mid);
            int right = Math.min(N, arr[m]+mid);

            for(int i=left; i<right; i++){
                isBright[i] = true;
            }
        }

        for(int i=0; i<N; i++){
            if(!isBright[i]) return false;
        }
        return true;
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            arr[m] = Integer.parseInt(st.nextToken());
        }
    }
}