
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        int cnt = 0;

        int[] arr = new int[10];

        for(int i=0; i<num.length(); i++){
            arr[num.charAt(i)-'0']++;
        }


        for(int i=0; i<10; i++){
            if(arr[6]!=0 || arr[9]!=0) {
                int mid = (arr[6]+ arr[9]+1)/2;
                arr[6] = mid;
                arr[9] = mid;
            }
        }


        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}
