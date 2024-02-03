import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        input();

        Arrays.sort(arr);


        int L = 0;
        int R =1000000000;

        int answer = 0;
        while(L <= R){
            int mid = (L+R)/2;

            if(isPossible(mid)) {
                answer = mid;
                L = mid + 1;
            }else{
                R = mid -1;
            }
        }

        System.out.println(answer);



    }


    //최소거리가 d인 상태에서 공유기 C개 설치가 가능한가
    public static boolean isPossible(int d){

        int cnt =1;
        int last = arr[0];

        for(int i=1; i<N; i++){
            if(arr[i]-last < d) continue;
            last= arr[i];
            cnt ++;
        }

        if(cnt >=C) return true;
        return false;

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }
    }

}