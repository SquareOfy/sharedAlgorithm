import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken()); //게임횟수
        double y = Double.parseDouble(st.nextToken()); //이긴게임


        long z = (long) ((y * 100) / x);

        if(z>=99) {
            System.out.println(-1);
            return;
        }

        long answer = 0;

        double left = 1;
        double right = x;
        long mid = (long) (left + right) / 2;
        while (left <= right) {

            mid = (long) (left + right) / 2;


            long p = (long) (((y + mid) * 100) / (x + mid));
            if (p > z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }
        System.out.println(answer);

    }
}