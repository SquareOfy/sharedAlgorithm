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

        int F = Integer.parseInt(st.nextToken()); //총 층수
        int S = Integer.parseInt(st.nextToken()); //현재 층수
        int G = Integer.parseInt(st.nextToken()); //목표 층수
        int U = Integer.parseInt(st.nextToken()); //한번 올라갈 때 층수
        int D = Integer.parseInt(st.nextToken()); //한번 내려갈 때 층수

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[F+1];
        visited[0] = true;
        queue.add(new int[]{S, 0});
        visited[S] = true;
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==G) min = Math.min(min, now[1]);

            int up = now[0]+U;
            int down = now[0]-D;
            if(up>0 && up<=F && !visited[up]) {
                queue.add(new int[]{up, now[1] + 1});
                visited[up] = true;
            }
            if(down>0 && down<=F && !visited[down]) {
                queue.add(new int[]{down, now[1] + 1});
                visited[down] = true;
            }
        }


        if(min!=Integer.MAX_VALUE) System.out.println(min);
        else System.out.println("use the stairs");


    }
}