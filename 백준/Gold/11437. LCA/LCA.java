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

    static int N,M, H;

    static int[] depth;
    static int[][] parents;

    static int target1, target2;

    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        input();

        init(1,1,0);

        fillParents();



        for(int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());
            target1 = Integer.parseInt(st.nextToken());
            target2 = Integer.parseInt(st.nextToken());

//
//            System.out.println("start ! ");
//
//            System.out.println("target 1 : " + target1);
//            System.out.println("target 2 : " + target2);
            while(depth[target1]!=depth[target2]){
                if(depth[target1] > depth[target2]){
                    target1 = parents[target1][0];
                }else{
                    target2 = parents[target2][0];
                }

//                System.out.println("target 1 : " + target1);
//                System.out.println("target 2 : " + target2);

            }





            while(target2!=target1){
                target1 = parents[target1][0];
                target2 = parents[target2][0];
            }

//            for(int j=0; j<=depth[target2]; j++){
//                if(target2==target1) break;
//                if(parents[target1][j] != parents[target2][j] ){
//                    target1 = parents[target1][j];
//                    target2 = parents[target2][j];
//                }
//            }

            sb.append(target1).append("\n");
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

    public static void init(int cur, int h, int par){
        depth[cur] = h;
        for(int i : list[cur]){
            if(i!=par){
                init(i, h+1, cur);
                parents[i][0] = cur;
            }
        }
    }

    public static void fillParents(){
        for(int i=1; i<H; i++){

            for(int n=1; n<=N; n++){
                parents[n][i] = parents[parents[n][i-1]][i-1];
            }
        }
    }
}