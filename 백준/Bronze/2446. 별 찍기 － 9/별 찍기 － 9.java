
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for(int n=1; n<=2*N-1; n++){
            int i = N-1-Math.abs(N-n);
            for(int j=0; j<i; j++){
                sb.append(" ");
            }

            int j = Math.abs(N-n)*2 +1;
            for(int k=0; k<j; k++){
                sb.append("*");
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }
}
