import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] coord = new int[N];
        for(int n=0; n<N; n++){
            coord[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coord);

        int[] gap = new int[N-1];

        for(int n=0; n<N-1; n++){
            gap[n] = coord[n+1]-coord[n];
        }

        Arrays.sort(gap);
        int result = 0;
        for(int i=0; i<N-K; i++){
            result+= gap[i];
        }


        System.out.println(result);

    }
}