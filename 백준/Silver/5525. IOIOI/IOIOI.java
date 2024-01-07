import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder("IOI");

        for(int n=0; n<N-1; n++){
            sb.append("OI");
        }
        String target = sb.toString();
        int cnt = 0;
        for(int i=0; i<M-target.length()+1; i++){
            if(s.substring(i, i+(2*N +1)).equals(target)) cnt++;
        }

        System.out.println(cnt);
    }
}