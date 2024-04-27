import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] note1, note2;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            input();

            Arrays.sort(note1);

            for(int m=0; m<M; m++){
                if(binary_search(note2[m])) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean binary_search(int n){

        int left =0;
        int right = N-1;
        while(left<=right){
            int mid = (left+right)/2;

            if(note1[mid]==n) return true;

            if(note1[mid]<n){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        note1 = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int n=0; n<N; n++){
            note1[n] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        note2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            note2[m] = Integer.parseInt(st.nextToken());
        }

    }
}