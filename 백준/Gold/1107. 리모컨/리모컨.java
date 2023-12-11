import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int M;
    static int[] buttons;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        buttons = new int[M];

        if(M>0) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                buttons[m] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;


        if(N ==100) {
            System.out.println(0);
            return;
        }
        min = countNow(N);

        if(M>0 && M<10) {
            if(isPossible(N)){
                min = Math.min(min, String.valueOf(N).length());
            }else {
                downCount();
                if (!(M == 9 && isPossible(0))) upCount();
            }
        }else if(M==0){
            min = Math.min(min, String.valueOf(N).length());
        }

        System.out.println(min);






    }

    public static void upCount(){
//        System.out.println("upCount 시작");
        int number = N+1;
        int count = 0;
        int now = 100;
        while(true){
//            System.out.println("number : " + number);
            if(isPossible(number)){
//                System.out.println("isPossible 가능");
//                System.out.println(number);
                count+=String.valueOf(number).length();
                while(number!=N){
                    count++;
                    number--;
                }
//                System.out.println(count);
                if(min<count) return;
                else min = count;
            }else{
                number++;
            }
        }
    }

    public static void downCount(){
//        System.out.println("downCount 시작");
        int number = N-1;
        int now = 100;
        int count =0;
        while(true){
            if(number<0) break;
            if(isPossible(number)){
//                System.out.println("isPossible 가능");
//                System.out.println(number);
                count+=String.valueOf(number).length();
                while(number!=N){
                    count++;
                    number++;
                }
//                System.out.println(count);
                if(min<count) break;
                else min = count;
                return;
            }else{
                number--;
            }
        }

    }

    public static boolean isPossible(int n){
        String str = String.valueOf(n);

        for(int i=0; i<str.length(); i++){
            for(int b : buttons){
                if(str.charAt(i)-'0' == b) return false;
            }
        }

        return true;

    }

    public static int countNow(int n){
        int now =100;
        int count =0;
        while(now!=N){
            if(now<N){
                now++;
                count++;
            }else{
                now--;
                count++;
            }
        }
//        System.out.println(count);

        return count;
    }
}