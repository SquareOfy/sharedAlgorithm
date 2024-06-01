import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int len = Arrays.stream(dp).max().getAsInt();
        sb.append(len).append("\n");
        int[] answer = new int[len];
        for(int i=N-1; i>=0; i--){
            if(dp[i]==len){
                answer[len-1] = arr[i];
                len--;
            }
        }

        for(int i=0; i<answer.length; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());



    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
    }
}