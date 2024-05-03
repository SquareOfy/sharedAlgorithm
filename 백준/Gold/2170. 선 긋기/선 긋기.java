import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long[][] arr;
    static int N;


    public static void main(String[] args) throws IOException {

        input();
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0]==o2[0]) {
                    if(o1[1]>o2[1]) return 1;
                    else if(o1[1]==o2[1]) return 0;
                    else return -1;

                }else if(o1[0]>o2[0]) return 1;
                else return -1;
            }
        });


        long answer = 0;


        answer += arr[0][1]-arr[0][0];
        long last = arr[0][1];
        for(int n=1; n<N; n++){
            //다음 선분의 시작점이 전에 끝나는 지점보다 작다면 겹치는 것. 그럼 전 지점부터 이 선분 끝나는 것만 answer에 더하기
            if(last > arr[n][0] && arr[n][1]>last) {
                answer += arr[n][1]-last;
            }
            else if(last<=arr[n][0]){
                answer+= arr[n][1]-arr[n][0];
            }
           last = Math.max(arr[n][1], last);

        }

        System.out.println(answer);

    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new long[N][2];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Long.parseLong(st.nextToken());
            arr[n][1] = Long.parseLong(st.nextToken());
        }
    }
}