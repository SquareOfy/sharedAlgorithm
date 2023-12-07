
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

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.add(new int[]{N,0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == K ){
                System.out.println(now[1]);
                return;
            }

            //앞으로 1보
            if(now[0]+1 <= 100000 && !visited[now[0]+1]){
                queue.add(new int[]{now[0]+1, now[1]+1});
                visited[now[0]+1] = true;
            }
            //뒤로 1보
            if(now[0]-1>=0 && !visited[now[0]-1]){
                queue.add(new int[]{now[0]-1, now[1]+1});
                visited[now[0]-1]=true;
            }
            //순간이동(*2)
            if(now[0]*2 <= 100000 && !visited[now[0]*2]){
                queue.add(new int[]{now[0]*2, now[1]+1});
                visited[now[0]*2] = true;
            }


        }

    }

}
