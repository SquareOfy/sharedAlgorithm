import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static int start;


    static int answerL;
    static int answerR;

    public static void main(String[] args) throws IOException {
        input();
        int idx1 = 0;
        int idx2 = 0;

        int start =1;
        int end = N;
        long min = Long.MAX_VALUE;

        while(start<end){
            long value = Math.abs(arr[start]+arr[end]);

            if(value<=min){
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

        System.out.println(arr[idx1]+ " "+arr[idx2]);

    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            if (start == 0 && arr[n] >= 0) start = n;

        }
    }
}