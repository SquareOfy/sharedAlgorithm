import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] seq;
    static int max;


    public static void main(String[] args) throws IOException {
        input();

        max = 0;

        int left = 0;
        int right = 0;
        int cnt = seq[0] % 2 == 0 ? 1 : 0;
        int deletecnt = 0;
        while (left < N && right < N) {
            if(max>=cnt) {
                right++;
                if (right == N) break;
                if (seq[right] % 2 == 0) {
                    cnt++;
                } else {
                    //홀수면 deleteCnt 늘릴 수 있으면 늘리기
                    if (deletecnt < K) deletecnt++;
                    else {
                        while (true) {
                            if (seq[left] % 2 == 0) cnt--;
                            left++;
                            if (left == N) break;
                            if (seq[left] % 2 != 0) break;
                        }
                    }


                }
            }else{
                max = Math.max(cnt, max);
            }


        }

        System.out.println(max);


    }

    public static int calculateLen(int left, int right) {
        int cnt = 0;
        int deleteCnt = 0;
        for (int i = left; i <= right; i++) {
            if (seq[i] % 2 == 0) cnt++;
            else {
                deleteCnt++;
                if (deleteCnt > K) {
                    return 0;
                }
            }
        }

        return cnt;
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            seq[n] = Integer.parseInt(st.nextToken());
        }

    }
}