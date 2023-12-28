import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] score = new int[N][2];
            for(int n=0; n<N; n++){

                st = new StringTokenizer(br.readLine());

                score[n][0] = Integer.parseInt(st.nextToken());
                score[n][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });


            int count = 0;
            int min = N;

            for(int n=0; n<N; n++){
                if(score[n][1]<=min) {
                    min = score[n][1];
                    count++;
                }

            }

            System.out.println(count);


        }

    }
}