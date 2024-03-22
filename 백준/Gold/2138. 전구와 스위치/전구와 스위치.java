import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static int N;
    static int[] original;
    static int[] goal;
    public static void main(String[] args) throws IOException {

        input();
        int[] copy = original.clone();


        //0을 안 누를 때
        int notPushCnt = go(original);




        //0을 누를 때
        change(copy, 0); //누르기

        int pushCnt = go(copy);

        //둘다 1이 아니면

        if(pushCnt == -1){
            System.out.println(notPushCnt);
        }else{
            System.out.println(notPushCnt!=-1? Math.min(notPushCnt, pushCnt+1):pushCnt+1);
        }



    }

    public static int go(int[] arr){
        int cnt =0;
        for(int i=1; i<N; i++){
            if(arr[i-1]!=goal[i-1]){
                change(arr, i);
                cnt ++;
            }
        }

        for(int i=0; i<N; i++){
            if(arr[i]!=goal[i]) return -1;
        }

        return cnt;
    }

    public static void change(int[] arr, int num){
        for(int i=num-1; i<=num+1; i++){
            if(i>=0 && i<N){
                arr[i] = 1-arr[i];
            }
        }
    }



    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        original = new int[N];

        goal = new int[N];
        String first = br.readLine();
        String second = br.readLine();
        for(int i=0; i<N; i++){
            original[i] = first.charAt(i)-'0';
            goal[i] = second.charAt(i)-'0';
        }


    }
}


