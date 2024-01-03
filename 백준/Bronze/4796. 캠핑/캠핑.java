import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt =1;

        while(true){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L==0) {
                System.out.println(sb.toString());
                return;
            }

            int result = L * (V/P);

            if(V%P > L) result+= L;
            else result+= V%P;

            sb.append("Case ").append(cnt).append(": ").append(result).append("\n");
            cnt++;
        }

    }
}