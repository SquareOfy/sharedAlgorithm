import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        input();


        Arrays.sort(arr);

        int[] sumArr = new int[N+1];

        for(int i=1; i<=N; i++){
            sumArr[i] = arr[i]+sumArr[i-1];
        }

        int answer = 0;
        for(int i=1; i<=N; i++){
            // 기존 [0, sumArr[i-1]]
            // 새로운 구간 [arr[i], sumArr[i]]
            if(sumArr[i-1]+1<arr[i]){
                answer = sumArr[i-1]+1;
                break;
            }
        }


        System.out.println(answer==0?sumArr[N]+1:answer);







    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }


    }
}