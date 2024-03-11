import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            stack.add(num);
        }

        int max =0;
        int cnt = 0;
        while(!stack.isEmpty()){
            int now = stack.pop();

            if(now>max){
                cnt++;
                max = now;
            }
        }

        System.out.println(cnt);
    }
}