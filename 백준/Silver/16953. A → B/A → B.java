import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());


        System.out.println(changeA(a, b));
    }


    public static long changeA(long a, long b){
        Queue<long[]> queue = new LinkedList<>();

        queue.add(new long[] {a, 1});

        while(!queue.isEmpty()){
            long[] now = queue.poll();



            long num = now[0];
            long rank = now[1];
//            System.out.println("num : " + num);

            if(num>b) continue;
            if(num*2==b || Long.parseLong(num+"1")==b) return rank+1;

            queue.add(new long[] {num*2, rank+1});

            queue.add(new long[] {Long.parseLong(num+"1"), rank+1} );


        }
        return -1;



    }
}