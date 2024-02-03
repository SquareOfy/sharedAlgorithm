
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }

        }

        int M = Integer.parseInt(br.readLine());

        st= new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb. append(map.get(num));
            }else{
                sb.append(0);
            }

            if(i!=M-1){
                sb.append(" ");
            }

        }

        System.out.println(sb.toString());
    }
}
