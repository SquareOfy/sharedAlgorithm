import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ = new PriorityQueue<>();//모래시계 윗쪽
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder()); // 모래시계 아래쪽
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine());

            if(minQ.size()==maxQ.size()){
                maxQ.add(num);
                if(!minQ.isEmpty()&& maxQ.peek()>minQ.peek()){
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }
            }else{
                minQ.add(num);
                if(!minQ.isEmpty()&& maxQ.peek()>minQ.peek()){
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }
            }

            sb.append(maxQ.peek()).append("\n");
        }
        System.out.println(sb.toString());


    }
}