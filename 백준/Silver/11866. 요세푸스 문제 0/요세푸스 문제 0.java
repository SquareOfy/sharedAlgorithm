
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int n = 1; n <= N; n++) {
            queue.add(n);
        }
        int cnt = 0;

        sb.append("<");

        while(cnt<N){
            for(int i=0; i<K; i++){
                int num = queue.poll();

                if(i!=K-1){
                    queue.add(num);
                }else if(i==K-1 && cnt<N-1){
                    cnt++;
                    sb.append(num).append(", ");
                }else{
                    cnt++;
                    sb.append(num).append(">");
                }
            }

        }

        System.out.println(sb.toString());

    }
}
