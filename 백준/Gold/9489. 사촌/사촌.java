import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k, target;
    static int[] parent;
    static int[] arr;



    public static void main(String[] args) throws IOException {

        while (true) {
            input();
            if (n == 0 && k == 0) break;

            int answer = 0;
            for(int i=1; i<=n; i++){
                if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]) answer ++;
            }



            sb.append(answer).append("\n");


        }
        System.out.println(sb.toString());

    }


    public static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == 0 && k == 0) return;
        parent = new int[n+1];
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int idx = -1;
        parent[0] = -1;
        arr[0] = -1;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]==k) target = i;
            if(arr[i]-arr[i-1]!=1) idx++;
            parent[i] = idx;
        }

    }


}