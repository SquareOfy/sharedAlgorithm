import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        //부모배열 세팅
        int[] parent = new int[n];
        for(int p=0; p<n; p++){
            parent[p] = p;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean flag = union(parent, start, end);

            if(flag) {
                System.out.println(i+1);
                return;
            }


        }

        System.out.println(0);




    }

    public static int find(int[] p, int x){
        if(p[x]==x) return x;
        return find(p, p[x]);
    }

    public static boolean union(int[] p, int x, int y){
        int dx = find(p, x);
        int dy = find(p, y);

        if(p[dy]==dx ||p[dx]==dy) return true;

        if(dx<dy) p[dy] = dx;
        else p[dx] = dy;
        return false;
    }

}