import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;
    static int[] arr, sumArr;

    public static void main(String[] args) throws IOException {
        input();

        HashMap<Integer, Integer> map = new HashMap<>();

        long answer =0;
        map.put(0, 1);
        for(int i=1; i<=N; i++){
            long tmp = map.getOrDefault(sumArr[i]-K,0);
            answer+=tmp;
            map.put(sumArr[i], map.getOrDefault(sumArr[i],0)+1);
        }


        System.out.println(answer);




    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        sumArr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = arr[i]+sumArr[i-1];
        }
    }
}