import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int K;

    static List<Integer>[] list ;
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        int node = (int)Math.pow(2, K)-1;
        arr = new int[node+1];

        int mid = node/2;

        list = new ArrayList[K+1];
        for(int i=0; i<=K; i++){
            list[i] = new ArrayList<>();
        }
        int[][] tree = new int[node][2];
        for(int i=1; i<=node; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(1, node+1, 1);

        for(int i=1; i<=K; i++){
            for(int j=0; j<list[i].size(); j++){
                sb.append(list[i].get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());



    }

    public static void solve(int st, int ed, int dep){
        if(st>ed) return;
        int mid = (st+ed)/2;

        list[dep].add(arr[mid]);
        if(dep == K) return;

        solve(st, mid-1, dep+1);
        solve(mid+1, ed, dep+1);


    }
}