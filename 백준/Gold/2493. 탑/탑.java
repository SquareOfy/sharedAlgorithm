
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> idxStack = new Stack<>();

        stack.push(Integer.parseInt(st.nextToken()));
        idxStack.push(1);
        sb.append(0).append(" ");
        for(int n=2; n<=N; n++){
            int num = Integer.parseInt(st.nextToken());


            while(!stack.isEmpty()){
                if(num < stack.peek()){
                    sb.append(idxStack.peek()).append(" ");
                    break;
                }

                idxStack.pop();
                stack.pop();
            }

            if(stack.isEmpty()) sb.append(0).append(" ");
            stack.push(num);
            idxStack.push(n);

        }

        System.out.println(sb.toString());




    }
}
