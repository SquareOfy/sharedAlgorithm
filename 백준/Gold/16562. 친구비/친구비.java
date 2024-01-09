import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        money = new int[N+1];
        for(int n=1;n<=N; n++){
            money[n] = Integer.parseInt(st.nextToken());
        }

        int[] parent = new int[N+1];
        for(int n=1; n<=N; n++){
            parent[n] = n;
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(parent, v, w);
        }


        //친구 수
        int cost =0 ;
        boolean[] visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            int parentIdx = find(parent, i);

            if(visited[parentIdx]){
                visited[i] = true;
                continue;
            }
            cost += money[parentIdx];
            visited[parentIdx] = true;
            visited[i] = true;
        }



        if(cost<=k) System.out.println(cost);
        else System.out.println("Oh no");


    }

    public static int find(int[] p, int x){
        if(p[x]==x) return x;
        return find(p, p[x]);
    }

    public static void union(int[] p, int x, int y){
        int dx = find(p, x);
        int dy = find(p, y);

        if(dx==dy) return;
        if(money[dx]<=money[dy]) p[dy] = dx;
        else p[dx] = dy;
    }
}