import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==1){
                int num = Integer.parseInt(st.nextToken());
                stack.add(num);
            }else if(order==2){
                if(!stack.isEmpty()){
                    sb.append(stack.pop()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }else if(order==3){
                sb.append(stack.size()).append("\n");
            }else if(order==4){
                if(stack.isEmpty()) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }else{
                if(stack.isEmpty()) sb.append(-1);
                else sb.append(stack.peek());
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}