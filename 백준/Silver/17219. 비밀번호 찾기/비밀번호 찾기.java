import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        int N=  Integer.parseInt(st.nextToken());
        int M=  Integer.parseInt(st.nextToken());

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            String address = st.nextToken();
            String pass = st.nextToken();

            map.put(address, pass);
        }

        for(int m =0; m<M; m++){
            String target = br.readLine();

            sb.append(map.get(target)).append("\n");
        }

        System.out.println(sb.toString());
    }
}