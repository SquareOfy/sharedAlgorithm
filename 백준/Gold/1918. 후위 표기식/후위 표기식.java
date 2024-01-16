import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int n=0; n<str.length(); n++){

            char c = str.charAt(n);

            if(c>=65 && c<=90) {
                sb.append(c);
            }else{
                if(c=='('){
                    stack.push(c);
                }else if(c==')'){
                    while(!stack.isEmpty() && stack.peek() !='('){
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty() && stack.peek() =='(') stack.pop();

                }else{
                   //+,-,*,/
                    while(!stack.isEmpty() && cal(stack.peek())>=cal(c)){
                        sb.append(stack.pop());
                    }
                    stack.push(c);

                }
            }
        }

       while(!stack.isEmpty()){
           sb.append(stack.pop());
       }

        System.out.println(sb.toString());
    }

    public static int cal(char c){
        if(c=='*' || c=='/') return 2;
        if(c=='+'||c=='-') return 1;
        else return 0;
    }
}