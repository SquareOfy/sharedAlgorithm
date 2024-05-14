import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;

        //행 판단
        outer:
        for (int r = 0; r < N; r++) {

            int cnt = 0;
            int last = map[r][0];
            for (int c = 0; c < N; c++) {

                //일정하다면
                if (last == map[r][c]) {
                    cnt++;
                } else {
                    if (Math.abs(last - map[r][c]) > 1) {
                        continue outer;
                    }
                    //올라가야 경사로를 놔야한다면 현재까지의 cnt가 L보다 크거나 같으면 놓을 수 있음
                    if (last < map[r][c] ) {
                        if (cnt >= L) {
                            last = map[r][c];
                            cnt = 1;
                        } else {
                            continue outer;
                        }
                        //내려가야하는 상황이라면
                    } else {
                        if (c + L - 1 >= N) {
                            continue outer; //남은 공간이 L만큼이 없으면
                        }
                        for (int i = 0; i < L; i++) {
                            if (map[r][c + i] != last - 1) {
                                continue outer;
                            }
                        }
                        last = map[r][c];
                        cnt = 0;
                        c+=L-1;
                    }
                }

            }
            answer++;
        }

        outer:
        for (int c = 0; c < N; c++) {

            int cnt = 0;
            int last = map[0][c];
            for (int r = 0; r < N; r++) {

                //일정하다면
                if (last == map[r][c]) {
                    cnt++;
                } else {
                    if (Math.abs(last - map[r][c]) > 1){
                        continue outer;
                    }
                    //올라가야 경사로를 놔야한다면 현재까지의 cnt가 L보다 크거나 같으면 놓을 수 있음
                    if (last < map[r][c]) {
                        if (cnt >= L) {
                            last = map[r][c];
                            cnt = 1;
                        } else{
                            continue outer;
                        }
                        //내려가야하는 상황이라면
                    } else {
                        if (r + L - 1 >= N) {
                            continue outer; //남은 공간이 L만큼이 없으면
                        }
                        for (int i = 0; i < L; i++) {
                            if (map[r + i][c] != last - 1){
                                continue outer;
                            }
                        }
                        last = map[r][c];
                        cnt =0;
                        r += L-1;
                    }
                }

            }
            answer++;
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
}