import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> chickenList;
    static int[][] result;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chickenList = new ArrayList<>();
        result = new int[M][2];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c]==2){
                    chickenList.add(new int[]{r,c});
                }
            }
        }

        visited = new boolean[chickenList.size()];

        comb(0, 0);
        System.out.println(min);



    }


    public static void comb(int cnt, int start){
        if(cnt ==M){
            int dist = calculateDist();

            min = Math.min(min, dist);
            return;
        }

        for(int i=start; i<chickenList.size(); i++) {
            if(visited[i]) continue;
            if (!visited[i]) {
                result[cnt][0] = chickenList.get(i)[0];
                result[cnt][1] = chickenList.get(i)[1];
                visited[i] = true;
                comb(cnt + 1, i+1);
                visited[i] = false;

            }
        }

    }

    public static int calculateDist(){
        int distSum =0;
        int dist = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    dist = Integer.MAX_VALUE;
                    for(int k=0; k<M; k++){
                        dist = Math.min(Math.abs(i-result[k][0])+Math.abs(j-result[k][1]), dist);
                    }
                    distSum += dist;


                }
            }
        }

        return distSum;
    }
}
