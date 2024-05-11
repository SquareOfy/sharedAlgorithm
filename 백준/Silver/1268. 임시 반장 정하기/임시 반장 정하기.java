import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N; //학생 수

    static int[][] map;

    public static void main(String[] args) throws IOException {

        input();

        boolean[][] visited = new boolean[N][N];
        int[] cnt = new int[N];
        int max = 0;
        int answer =1;

        for(int n=0; n<N; n++){

            for(int i=0; i<5; i++) {
                for (int m = n + 1; m < N; m++) {
                    if(map[n][i]==map[m][i] ){
                        if(!visited[n][m]) {
                            cnt[n]++;
                            cnt[m]++;
                            visited[n][m] = true;
                            visited[m][n] = true;
                            if(max<cnt[n]){
                                answer = n+1;
                                max = cnt[n];
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);





    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][5];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<5; i++){
                map[n][i] = Integer.parseInt(st.nextToken());
            }

        }
    }
}