import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int n=0; n<N; n++){
            for(int m=0; m<n; m++){
                sb.append(" ");
            }
            for(int m=2*N-1-2*n; m>0; m--){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}