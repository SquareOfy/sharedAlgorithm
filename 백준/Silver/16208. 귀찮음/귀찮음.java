import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    static int sum;

    public static void main(String[] args) throws IOException {

        input();

        long answer =0;

        Arrays.sort(arr);


        for(int i=0; i<N; i++){
            answer+= ((long) arr[i] * (sum-arr[i]));
            sum -= arr[i];
        }

        System.out.println(answer);

    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sum =0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
    }
}