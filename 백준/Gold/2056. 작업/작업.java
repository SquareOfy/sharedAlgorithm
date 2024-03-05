import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int answer;
    static int N;
    static int[] degree;
    static int[] time;
    static int[] maxTime;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        input();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next : list[now]){
                maxTime[next] = Math.max(maxTime[now]+time[now], maxTime[next]);
                degree[next]--;
                if(degree[next]==0){
                    queue.add(next);
                }
            }
        }

        for(int i=1; i<=N; i++){
            answer = Math.max(maxTime[i]+time[i],answer );
        }

        System.out.println(answer);


    }

    public static void input() throws IOException {

        N = Integer.parseInt(br.readLine());


        time = new int[N+1];
        degree = new int[N+1];
        maxTime = new int[N+1];

        list = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            list[n] = new ArrayList<>();
        }

        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());

            time[n] = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num==0) break;
                degree[n] ++;


                list[num].add(n);

            }
        }

    }

}