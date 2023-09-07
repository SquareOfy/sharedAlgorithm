
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] operator;
    static int[] operatorCnt;
    static int visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        operatorCnt = new int[4];
        operator = new int[N-1];
        visited = new int[4];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            operatorCnt[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);

        System.out.println(max);
        System.out.println(min);
    }


    public static void perm(int cnt) {
        if (cnt == N - 1) {
            int result = operate(operator[0], nums[0], nums[1]);
            for(int i=1; i<N-1; i++){
                result = operate(operator[i], result, nums[i+1]);
            }


            min = Math.min(result, min);
            max = Math.max(result, max);


            return;
        }

        for (int i = 0; i < 4; i++) {
            if (visited[i] < operatorCnt[i]) {
                operator[cnt] = i;
                visited[i]++;
                perm(cnt + 1);
                visited[i]--;
            }
        }

    }

    public static int operate(int operator, int num1, int num2){

        if(operator==0){
            return num1+num2;
        }else if(operator ==1){
            return num1-num2;
        }else if(operator ==2){
            return num1*num2;
        }else{
            return num1/num2;
        }
    }


}
