import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long answer = a * b / gcd(a, b);
        System.out.println(answer);



    }
    public static long gcd(long a, long b){
        long tmp = b;
        while(b!=0){
            tmp = b;
            b = a%b;
            a = tmp;
        }

        return a;
    }
}