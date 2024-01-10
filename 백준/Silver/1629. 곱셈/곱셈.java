import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());



        if(A==1) System.out.println(A%C);
        else {
            long result = cal(A, B, C);

            System.out.println(result);
        }


    }

    public static long cal(long a, long b, long c){
        if(b==1) return a%c;

        long k = cal(a, b/2, c);
        if(b%2==0){
            return k*k%c;
        }else{
            return (k*k%c)*a%c;
        }

        
    }
}