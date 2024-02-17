import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N, K, W;
    static int[] time;
    static int[] degree;
    static ArrayList<Integer>[] list;

    static int[] maxTime;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            input();

            Queue<Integer> queue = new LinkedList<>();

            for(int i=1; i<=N; i++){
                if(degree[i]==0) queue.add(i);
            }


            while(!queue.isEmpty()){
                int now = queue.poll();

                for(int next : list[now]){
                    maxTime[next] = Math.max(maxTime[now]+time[now], maxTime[next] );
                    degree[next]--;
                    if(degree[next] ==0) queue.add(next);
                }
            }

            sb.append(maxTime[W]+time[W]).append("\n");
        }

        System.out.println(sb.toString());
    }
    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[N+1];
        degree = new int[N+1];
        maxTime = new int[N+1];
        list = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            list[n] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=N; n++){
            time[n] = Integer.parseInt(st.nextToken());
        }

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            list[before].add(after);
            degree[after]++;
        }

        W = Integer.parseInt(br.readLine());


    }


}