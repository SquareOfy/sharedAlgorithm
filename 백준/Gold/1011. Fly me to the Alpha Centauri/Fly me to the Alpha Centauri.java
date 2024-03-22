import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int d = b-a;
            int max = (int) Math.sqrt(d);
            if(max == Math.sqrt(d)) sb.append(2*max -1);
            else if(d<=max*max+max){
                sb.append(2*max);

            }else{
                sb.append(2*max+1);
            }

            sb.append("\n");



        }

        System.out.println(sb.toString());
    }
}