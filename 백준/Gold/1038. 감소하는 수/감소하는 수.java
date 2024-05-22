import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N<= 10) {
            System.out.println(N);
            return;
        }else{

            list = new ArrayList<>();

            for(int i=1; i<=9; i++){
                makeDecreaseNum((long)i);
            }


            if(list.size()>=N) {
                Collections.sort(list);

                System.out.println(list.get(N-1));
            }else System.out.println(-1);
            
        }
    }

    public static void makeDecreaseNum(long num){

        list.add(num);

        int last = (int) (num%10);

        if(last==0) return;

        for(int i=last-1; i>=0; i--){
            long next = num*10+i;
            makeDecreaseNum(next);
        }
    }




}