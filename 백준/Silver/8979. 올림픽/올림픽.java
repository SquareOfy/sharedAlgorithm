import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int[][] medals;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        input();


        Arrays.sort(medals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    if(o1[1]==o2[1]){
                        return o2[2]-o1[2];
                    }
                    return o2[1]-o1[1];
                }
                return o2[0]-o1[0];
            }
        });

        medals[0][4]=1;
        int cnt =1;

        outer: for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                if(medals[i-1][j]>medals[i][j]){
                    medals[i][4] = medals[i-1][4]+cnt;
                    cnt =1;
                    continue outer;
                }
            }
            medals[i][4] = medals[i-1][4];
            cnt ++;
        }

        for(int i=0; i<N; i++){
            if(medals[i][3]==K){
                sb.append(medals[i][4]);
                break;
            }
        }
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());
        medals = new int[N+1][5];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            medals[n][3] = idx;
            for(int i=0; i<3; i++){
                medals[n][i] = Integer.parseInt(st.nextToken());
            }

        }
    }
}