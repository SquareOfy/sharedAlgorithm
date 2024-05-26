import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    static long[] sumArr;
    static boolean[] visited;
    static long answer;

    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();

        selected = new int[2];
        answer = Long.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            sumArr[i] += arr[i] + sumArr[i - 1];
        }

        //1번째 혹은 N번째는 반드시 골라야 함
        //1을 뽑을 때
        selected[0] = 1;
        visited[1] = true;
        pickBeePlace(1);
        visited[1] = false;

        //N을 뽑을때
        selected[1] = N;
        visited[N] = true;
        pickBeePlace(2);

        selected = new int[]{1, N};
        pickMidHome();

        System.out.println(answer);
    }

    static void pickBeePlace(int flag) {

        if (flag == 1) {
            for (int i = 2; i < N; i++) {
                visited[i] = true;
                selected[1] = i;
                pickRightHome();
                visited[i] = false;
            }
        } else {//N이 반드시 뽑힐때
            for (int i = 2; i < N; i++) {
                visited[i] = true;
                selected[0] = i;
                pickLeftHome();
                visited[i] = false;

            }
        }

    }

    static void pickLeftHome() {


        //벌집이 왼쪽에 있을 때 (제일 왼쪽에 벌이 없어야 함)
        if (!visited[1]) {
            long cnt = 0;
            cnt += sumArr[selected[0] - 1] - sumArr[0];
            cnt += sumArr[selected[1] - 1] - sumArr[0];
            cnt -= arr[selected[0]];
            answer = Math.max(answer, cnt);
        }



    }

    static void pickRightHome() {
        //벌집이 오른쪽에 있을 때는 무조건 제일 끝값 (제일 오른쪽에 벌이 없어야함)
        if (!visited[N]) {
            long cnt = 0;
            cnt += sumArr[N] - sumArr[selected[0]];
            cnt += sumArr[N] - sumArr[selected[1]];
            cnt -= arr[selected[1]];
            answer = Math.max(answer, cnt);
        }
    }

    static void pickMidHome() {
        //벌집이 사이에 있을 때 (벌 연속 위치x)
        long cnt = sumArr[selected[1] - 1] - sumArr[selected[0]];
        int max = 0;
        for (int i = selected[0] + 1; i < selected[1]; i++) {
            max = Math.max(arr[i], max);
        }
        cnt += max;
        answer = Math.max(answer, cnt);

    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        sumArr = new long[N + 1];
        for (int n = 1; n <= N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
    }
}