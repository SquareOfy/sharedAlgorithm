import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();



        long sum = 0;


        int N = Integer.parseInt(br.readLine());

        int[][] points = new int[N][2];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            points[n][0] = Integer.parseInt(st.nextToken());
            points[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];

                }
                return o1[0]-o2[0];
            }
        });




        for(int n=0; n<N; n++){
            int len = Integer.MAX_VALUE;
            if(n>0 && points[n][1]==points[n-1][1]){
                int idx = n-1;
                while(true){
                    if(Math.abs(points[n][0]-points[idx][0])<len){
                        len = Math.abs(points[n][0]-points[idx][0]);

                    }else break;
                    idx --;
                    if(idx<0 || points[idx][1]!=points[n][1]) break;
                }
            }

            if(n<N-1 && points[n][1]==points[n+1][1]){
                int idx = n+1;
                while(true){
                    if(Math.abs(points[n][0]-points[idx][0])<len){
                        len = Math.abs(points[n][0]-points[idx][0]);
                    }else break;
                    idx ++;
                    if(idx==N || points[idx][1]!=points[n][1]) break;
                }
            }

            sum+=len;
        }

        System.out.println(sum);

    }
}