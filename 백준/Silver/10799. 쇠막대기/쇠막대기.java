import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String str ;
    public static void main(String[] args) throws IOException {

        input();

        int N = str.length();
        int cnt =0;
        int answer = 0;
        boolean isLayser = false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<N; i++){
            char c = str.charAt(i);
            if(c=='('){
                isLayser = true;
                answer ++;
                cnt ++;
                stack.add('(');
            }else{
                if(isLayser){ //레이저일때 (바로 앞이 '('일 때)
                    answer--;
                    cnt--;
                    answer+= cnt;
                    stack.pop();
                    isLayser = false;
                }else{ //레이저가 아닐때 : 바로 앞이 ')'였을 때
                    cnt --;
                    stack.pop();
                }
            }

        }

        System.out.println(answer);

    }



    public static void input() throws IOException {
        str = br.readLine();
    }

}