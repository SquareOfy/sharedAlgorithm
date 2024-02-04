import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, x;
    static int[] arr;


    public static void main(String[] args) throws IOException {

        input();

        Arrays.sort(arr);
        int cnt =0;


        for(int i=0; i<n-1; i++){
            if(x-arr[i] <=0) continue;

            if(isExist(x-arr[i], i+1, n-1)) cnt++;
        }

        System.out.println(cnt);


    }

    public static boolean isExist(int num, int L, int R){

        while(L<=R){
            int mid = (L+R)/2;

            if(arr[mid]==num) return true;

            if(arr[mid]<num){
                L = mid+1;

            }else R = mid -1;
        }
        return false;
    }




    public static void input() throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());
    }
}