import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();


        int left =0;
        int right =0;
        int sum = arr[0];
        int answer =0;

        while(right<N && left<N){
            if(sum<M){

                right++;
                if(right==N) break;
                sum+=arr[right];
            }else{
                if(sum==M){
                    answer++;
                }

                sum-=arr[left];
                left++;
            }
        }

        System.out.println(answer);



    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}