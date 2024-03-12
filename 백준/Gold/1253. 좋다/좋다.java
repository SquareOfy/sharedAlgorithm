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

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(arr);
        int answer= 0;


        for(int i=0; i<N; i++){
            long sum = arr[i];

            int left = 0;
            int right = N-1;
            while(left<right){
                if(left==i) {
                    left ++;
                    continue;
                }
                if(right==i) {
                    right--;
                    continue;
                }

                if(arr[left]+arr[right]>sum) right--;
                else if(arr[left]+arr[right]<sum) left++;
                else{
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);


    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}