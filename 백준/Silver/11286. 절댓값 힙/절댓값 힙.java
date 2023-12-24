import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)-Math.abs(o2)!=0) return Math.abs(o1)-Math.abs(o2);
                else return o1-o2;
            }
        });

        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0 ){

                if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append(0).append("\n");
            }
            else {
                pq.add(num);
            }

        }

        System.out.println(sb.toString());
    }
}