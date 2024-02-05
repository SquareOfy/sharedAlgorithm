import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        input();


        int L = Arrays.stream(arr).max().getAsInt();
        int R = 1000000000;
        int answer =0;
        while (L <= R) {
            int wallet = 0;
            int cnt = 0;

            int mid = (L+R)/2;
            for (int n = 0; n < N; n++) {
                if (wallet < arr[n]) {
                    wallet = mid - arr[n];
                    cnt++;

                }else{
                    wallet -= arr[n];
                }
            }


            if(cnt<=M){
                answer = mid;
                R = mid - 1;

            }else{
                L = mid + 1;
            }
        }

        System.out.println(answer);


    }


    public static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }

    }

}