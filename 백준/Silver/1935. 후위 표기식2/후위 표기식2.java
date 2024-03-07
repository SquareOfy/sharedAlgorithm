import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        HashMap<Integer, Double> map = new HashMap<>();
        int idx = 65;
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine());
            map.put(idx++, (double) num);
        }

        //A =65 Z=90

        Stack<Double> stack = new Stack<>();


        for(int i=0; i<str.length(); i++){

            if((int)str.charAt(i)>=65 && (int)str.charAt(i)<=90){
                stack.add(map.get((int)str.charAt(i)));
            }else{
                //계산
                double num1 = stack.pop();
                double num2 = stack.pop();

                double result= 0;
                if(str.charAt(i)=='*') {
                    result = num1*num2;
                }
                else if(str.charAt(i)=='+'){
                    result = num1+num2;
                }
                else if(str.charAt(i)=='-') {
                    result = num2-num1;
                }
                else {
                    result = num2/num1;
                }

                stack.push(result);
            }

        }

        System.out.println(String.format("%.2f", stack.pop()));
    }

    public static int cal(char c){
        if(c=='*' || c=='/') return 2;
        if(c=='+'||c=='-') return 1;
        else return 0;
    }
}