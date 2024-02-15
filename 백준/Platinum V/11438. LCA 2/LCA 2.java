import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int N,M;
    static int H;

    static int[][] parents;
    static int[] depth;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {

        input();
        dfs(1, 0, 1);
        setParents();
        
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            int answer = lca(a,b);
            sb.append(answer).append("\n");




        }


        System.out.println(sb);


    }




    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

       list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        H = (int) Math.ceil(Math.log(N)/Math.log(2))+1;
        depth = new int[N+1];
        parents = new int[N+1][H];

        M = Integer.parseInt(br.readLine());
    }

    public static void dfs(int a,  int par, int dep){

        depth[a] = dep;

        for(int i:list[a]){
            if(i==par) continue;
            dfs(i, a, dep +1);
            parents[i][0] = a;


        }

    }
    public static void setParents(){
        for(int j=1; j<H; j++){
            for(int i=1; i<=N; i++){
                parents[i][j] = parents[parents[i][j-1]][j-1];
            }
        }
    }

    public static int lca(int a, int b){
        if(depth[a]>depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int i= H-1; i>=0; i--){

            if(depth[b]-depth[a] >= (1<<i)){
                b = parents[b][i];
            }
//            if(Math.pow(2, i) <= depth[b] - depth[a]){
//                b = parents[b][i];
//            }
        }

        if(a==b) return a;
        for(int i=H-1; i>=0; i--){
            if(parents[a][i]!=parents[b][i]){
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0];
    }
}