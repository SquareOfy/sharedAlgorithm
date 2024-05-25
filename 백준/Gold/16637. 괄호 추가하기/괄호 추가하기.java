import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int answer;

    static String str;

    public static void main(String[] args) throws IOException {

        input();
        answer = Integer.MIN_VALUE;

        dfs(0, 0);

        System.out.println(answer);


    }

    public static void dfs(int idx, int value) {

        //종료조건

        if (idx >= N) {
            answer = Math.max(answer, value);
            return;
        }

        char oper = idx == 0 ? '+' : str.charAt(idx - 1);


        //내 다음에 나오는 숫자 괄호 묶어보기
        //이전 값에 괄호 묶어 나온 값을 이전 연산처리하기
        if (idx + 2 < N) {

            int a = str.charAt(idx) - '0';
            int b = str.charAt(idx + 2) - '0';
            int tmp = calculate(a, b, str.charAt(idx + 1));
            dfs(idx + 4, calculate(value, tmp, oper));

        }

        //괄호 안묶고 계산
        dfs(idx + 2, calculate(value, str.charAt(idx) - '0', oper));


    }

    public static int calculate(int a, int b, char operation) {
        if (operation == '+') {
            return a + b;
        } else if (operation == '-') return a - b;
        else return a * b;
    }


    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        str = br.readLine();

    }
}