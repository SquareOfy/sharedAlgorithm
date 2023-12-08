import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count =0;
        int min = Integer.MAX_VALUE;

        if(N>=K){
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        //방문 횟수
        int[] visited = new int[100001];
        //첫 위치
        queue.add(new int[]{N,0});

        visited[N] = 1;
        while(!queue.isEmpty()){

            int[] now = queue.poll();

                int[] next = {now[0]-1, now[0]+1, now[0]*2};



                for(int i=0; i<3; i++){
                    if(next[i] <= 100000 && next[i]>=0){
                        if(visited[next[i]]==0 || visited[next[i]] >= visited[now[0]] +1 ){
                            queue.add(new int[] {next[i], now[1]+1});
                            visited[next[i]]=visited[now[0]]+1;


                        }

                        if(next[i]==K){
                            if(now[1]<=min){
                                min = now[1];
                                count++;
                            }
                        }

                    }
                }

            }



        System.out.println(visited[K]-1);
        System.out.println(count);

    }

}