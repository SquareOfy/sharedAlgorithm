import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 3) {
            System.out.println(0);
            return;
        }

        int max = N-2;
        int a = 0;
        int b = 0;
        int cnt = 0;

        while (true) {

            for(int i=1; i<=(N-max)/2; i++){
                a = i;
                b = N-max-i;

                if(a>max || b>max) continue;
                if(max<a+b){
                    cnt++;
                }
            }

            max--;
            if(max<N/3) break;
        }

        System.out.println(cnt);

    }
}