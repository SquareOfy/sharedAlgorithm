import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            Map<String, Integer> map = new HashMap<>();
            int F = Integer.parseInt(br.readLine());
            int idx = 0;

            int[] parents = new int[F*2+1];
            for(int p=0; p<parents.length; p++){
                parents[p] = p;
            }
            int[] cntArr = new int[F*2+1];
            Arrays.fill(cntArr, 1);
            for(int f=0; f<F; f++){
                st = new StringTokenizer(br.readLine());

                String id1 = st.nextToken();
                String id2 = st.nextToken();

                if(!map.containsKey(id1)){
                    map.put(id1, ++idx);
                }
                if(!map.containsKey(id2)){
                    map.put(id2, ++idx);
                }

                union(parents, cntArr, map.get(id1), map.get(id2));

                sb.append(cntArr[find(parents, map.get(id1))]).append("\n");

            }
        }
        System.out.println(sb.toString());
    }

    public static int find(int[] p , int a){
        if(p[a]==a) return a;
        return find(p, p[a]);
    }

    public static void union(int[] p, int[] cnt, int a, int b){
        int x = find(p, a);
        int y = find(p, b);
        if(x!=y) {
            p[y] = x;
            cnt[x] +=cnt[y];
            cnt[y] =cnt[x];
        }

    }
}