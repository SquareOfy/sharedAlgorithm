import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int r = 1000 -N;
        int result = 0;
        result += r / 500;
        r %= 500;
        result += r/ 100;
        r %= 100;

        result += r/ 50;
        r %= 50;

        result += r/ 10;
        r %= 10;


        result += r/ 5;
        r %= 5;

        result += r/ 1;
        r %= 1;

        System.out.println(result);
    }
}