import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    //반례
    //1111410152345698716121317181920212223242526272829303132333435363738394041424344455046
    //12345111213141516678910

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String str;
    static int[] selected;
    static boolean[] visited;
    static boolean[] used;
    static int n;
    static boolean flag;
    static int twoPoint;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        input();

        flag = false;
        int len = str.length();
        n = 0;
        if (len < 10) n = len;
        else {
            n = 9 + (len - 9) / 2;
        }

        selected = new int[n];
        used = new boolean[str.length()];
        visited = new boolean[n + 1];

        twoPoint = n / 10;

        brute_force(0, 0);
        System.out.println(sb.toString());


    }

    public static void brute_force(int cnt, int idx) {

        //종료조건 다 뽑았을 때 조건에 맞는지 보고 SB에 APPEND
        if (cnt == n && !flag) {
            //visited 전부 썼는지 체크하고 출력
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) return;
            }
            for (int i = 0; i < selected.length; i++) {
                sb.append(selected[i]).append(" ");
            }
            flag = true;
            return;
        }


        if (flag) return;

        int num = str.charAt(idx) - '0';


        if (num == 0) return;

        //그 자리 숫자 사용한 적 없으면 뽑아보기
        if (!visited[num]) {
            visited[num] = true;
            selected[cnt] = num;
            used[idx] = true;
            brute_force(cnt + 1, idx + 1);
            used[idx] = false;
            visited[num] = false;
        }

        if (num <= twoPoint && idx + 1 < str.length()) { //두자리 가능한 숫자라면?
            num = Integer.parseInt(str.substring(idx, idx + 2));


            if (num <= n && !visited[num]) {
                visited[num] = true;
                selected[cnt] = num;
                used[idx] = true;
                used[idx + 1] = true;
                brute_force(cnt + 1, idx + 2);
                used[idx] = false;
                used[idx + 1] = false;
                visited[num] = false;
            }
        }


    }

    public static void input() throws IOException {
        str = br.readLine();
    }

}