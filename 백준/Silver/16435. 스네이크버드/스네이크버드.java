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
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int len = L;
        for(int n=0; n<N; n++){
            if(arr[n] <= len ){
                len ++;
            }else break;
        }

        System.out.println(len);
    }
}