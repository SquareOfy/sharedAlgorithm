
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String result = "";
        if(N % 2 ==0 ) result = "SK";
        else result = "CY";

        System.out.println(result);
    }
}
