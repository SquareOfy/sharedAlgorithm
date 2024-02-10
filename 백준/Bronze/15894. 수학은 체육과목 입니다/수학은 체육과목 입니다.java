import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static long N;

    public static void main(String[] args) throws IOException {
        input();

        long sum = 4*N -2*(N-1);

        if(N>1) sum += 2*(N-1);

        System.out.println(sum);
    }
    static void input() throws IOException {
        N = Long.parseLong(br.readLine());
    }
}