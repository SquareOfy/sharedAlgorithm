import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int idx = 1;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && stack.peek()==idx){
                idx++;
                stack.pop();
            }
            if(arr[i]==idx){
                idx++;
            }else{
                stack.add(arr[i]);
            }
        }

        while(!stack.isEmpty() && stack.peek()==idx){
            idx++;
            stack.pop();
        }

        if(idx==N+1) System.out.println("Nice");
        else System.out.println("Sad");


    }

    static void input() throws IOException {
        N  =Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }


}