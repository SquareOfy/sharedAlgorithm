import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드 수
        int M = Integer.parseInt(st.nextToken());

        final int INF = N*N;
        boolean[][] dist = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) dist[i][j] = true;
            }
        }


        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = true;
        }


        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][k] && dist[k][j]) dist[i][j] = true;
                }
            }
        }


        int result = 0;
        for(int i=1; i<=N; i++){ //i번째 학생이 알 수 있는가?
            int cnt =0;
            for(int j=1; j<=N; j++){
                if(i!=j && (dist[i][j] || dist[j][i])) cnt++;

            }

            if(cnt==N-1) result ++;
        }

        System.out.println(result);



    }
}