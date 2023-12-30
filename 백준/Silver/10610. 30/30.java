import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int[] cntArr = new int[10];

        boolean hasZero = false;
        long sum = 0;
        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i)-'0';

            cntArr[num] ++;
            sum += num;
        }

        if(str.contains("0") && sum%3 ==0){



            for(int i=9; i>=0; i--){
                while(cntArr[i]>0){
                    sb.append(i);
                    cntArr[i]--;
                }
            }

            System.out.println(sb.toString());
        }else{
            System.out.println(-1);
        }
    }
}