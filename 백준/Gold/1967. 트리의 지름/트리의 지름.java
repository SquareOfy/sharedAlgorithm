import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max;
    static List<Node>[] arr;
    static int n;
    static boolean[] visited;

    public static class Node{
        int num;
        int cost;

        public Node(int num, int cost){
            this.cost = cost;
            this.num = num;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }


        max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());


            arr[x].add(new Node(y, value));
            arr[y].add(new Node(x, value));
        }

        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            dfs(i, 0);
        }

        System.out.println(max);

    }

    public static void dfs(int k, int cnt) {

        visited[k] = true;

        for(int i=0; i<arr[k].size(); i++){
            if(!visited[arr[k].get(i).num]){
                dfs(arr[k].get(i).num, cnt+arr[k].get(i).cost);
            }
        }
        max = Math.max(max, cnt);

    }


}