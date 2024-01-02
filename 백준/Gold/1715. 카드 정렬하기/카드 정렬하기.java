import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n=0;n <N; n++){
            pq.add(Integer.parseInt(br.readLine()));
        }



        int result = 0;
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(pq.isEmpty()) {
                System.out.println(result);
                return;
            }
            int b = pq.poll();

            pq.add(a+b);
            result += a+b;
        }


    }
}