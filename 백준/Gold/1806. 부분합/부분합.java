import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] arrSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            arrSum[n] = arr[n] + arrSum[n - 1];

        }

        int left = 1;
        int right = 1;
        int answer = Integer.MAX_VALUE;

        int sum = arr[1];
        while (true) {

            if(sum<S){
                right++;
                if(right>N) break;
                sum+=arr[right];
            }else{
                sum-=arr[left];
                answer = Math.min(answer, right-left+1);
                left++;

            }

        }

        System.out.println(answer==Integer.MAX_VALUE ? 0 : answer);
    }
}