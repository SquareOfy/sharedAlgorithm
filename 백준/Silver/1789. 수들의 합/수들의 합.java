
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        long i=0;
        long sum = 0;
        while(sum<N){
            sum+=i;
            if(sum>=N) break;
            i++;
        }

        if(sum==N) System.out.println(i);
        else System.out.println(i-1);

    }

}
