import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S;
    static int[] arr;
    static long answer;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        answer = 0;
        input();
        sum(0, N/2, 0);
        sum(N/2, N, 0);
        if(S==0) answer --;
        System.out.println(answer);


    }

    public static void sum(int start, int end, int sum){


        if(start == end){
            if(end ==N) {
                answer += map.getOrDefault(S-sum, 0);
            }

            else{
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
            return;
        }

        sum(start+1, end, sum+arr[start]);
        sum(start+1, end, sum);

    }


    public static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }


    }
}