import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        long answer = arr[0] + arr[1];
        long min = 2000000000;

        int left = 0;
        int right = N-1;

        while (left <  right) {

            long tmp = arr[left] + arr[right];
            if (Math.abs(tmp) < Math.abs(answer)) {

                answer = arr[left] + arr[right];
            }

            if(tmp<0){
                left++;
            }else if(tmp>0){
                right--;
            }else{
                break;
            }
        }

        System.out.println(answer);
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
    }
}