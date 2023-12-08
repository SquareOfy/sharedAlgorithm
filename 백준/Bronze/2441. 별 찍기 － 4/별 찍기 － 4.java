import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++){
            for(int k=0; k<i; k++){
                sb.append(" ");
            }
            for(int j=N-i; j>0; j--){
                sb.append("*");

            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}