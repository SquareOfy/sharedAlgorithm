
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] money = new int[] {25, 10, 5, 1};
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            for(int j=0; j<4; j++){
                int q = N / money[j];
                System.out.print(q + " ");
                N = N % money[j];
            }
            System.out.println();
        }
    }
}
