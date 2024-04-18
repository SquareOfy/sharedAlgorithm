import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static Stack<Integer> stack;
    static int[] arr;
    static int[] answer;

    // 9
    // 1 5 4 6 100 14 7 20 100
    // 5 6 6 100 -1 20 20 100 -1

    public static void main(String[] args) throws IOException {
        input();
        StringBuilder sb = new StringBuilder();

        stack.add(0);
        Arrays.fill(answer, -1);
        for (int i = 1; i < N; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int num = stack.pop();
                answer[num] = arr[i];
            }
            stack.add(i);

        }

        for(int i=0; i<N; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());

    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        arr = new int[N];
        answer = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n]=Integer.parseInt(st.nextToken());
        }
    }

}