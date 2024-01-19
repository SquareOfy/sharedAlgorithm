import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static List<int[]>[] list;
//    static int[][] arr;
    static boolean[] visited;
    static int result;
    static int maxIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
//        arr = new int[V+1][V+1];

        list = new ArrayList[V+1];
        for(int v=1; v<=V; v++){
            list[v] = new ArrayList<>();
        }
        result = 0;

        int maxLen = 0;
        maxIdx = -1;


        List<Integer> cntList = new ArrayList<>();
        for(int i=1; i<=V; i++){
            st= new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int sum = 0;
            while(st.hasMoreTokens()){
                int v = Integer.parseInt(st.nextToken());
                if(num ==-1) break;
                int len = 0;
                if(st.hasMoreTokens()){
                    len = Integer.parseInt(st.nextToken());
                    list[num].add(new int[] {v, len});

                }

            }


        }



        visited = new boolean[V+1];
        dfs(1, 0);

        visited = new boolean[V+1];
        dfs(maxIdx, 0);

        System.out.println(result);

    }
    static void dfs(int v, int cnt){

        visited[v] = true;
        if(cnt>result){
            maxIdx=v;
            result = cnt;
        }

        for(int[] arr : list[v]){
            if(!visited[arr[0]]){
                dfs(arr[0], cnt+arr[1]);
            }
        }

    }
}