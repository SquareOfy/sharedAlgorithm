import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static int A,B;
//    static List<Integer>[] tree;
    static int[] tree;
    static List<Integer> parentList;

    static int answer;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            input();

            answer =0;
            parentList = new ArrayList<>();

            dfs(A);


            dfsB(B);

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }

    public static void dfs(int node){
        parentList.add(node);

        if(tree[node]==0) {
            return;
        }
        dfs(tree[node]);
    }

    public static void dfsB(int node){
        if(parentList.contains(node)) {
            answer = node;
            return;
        }
            dfsB(tree[node]);



    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        tree = new int[N+1];

        for(int n=0; n<N-1; n++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            tree[child] = parent;
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
}