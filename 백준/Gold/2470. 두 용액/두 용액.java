import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];



        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int idx1 = 0 ;
        int idx2 = 0;

        int start = 0;
        int end = N-1;

        while(start<end){
            int value = Math.abs(arr[start]+arr[end]);

            if(value<min){
                min = value;
                idx1 = start;
                idx2 = end;
            }

            if(arr[start]+arr[end]<0){
                start++;
            }else if(arr[start]+arr[end]>0){
                end--;
            }else{
                break;
            }
        }

        System.out.println(arr[idx1] + " "+arr[idx2]);





    }
}