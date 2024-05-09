import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long d = gcd(a,b);

            sb.append(a*b/d).append("\n");

        }
        System.out.println(sb.toString());
    }

    public static long gcd(long a,long b){
        if(a<b){
            long tmp = b;
            b = a;
            a = tmp;
        }

        if(b==0) return a;

        return gcd(b, a%b);

    }
}