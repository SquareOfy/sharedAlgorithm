
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N][N];

        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dist[i][j];

            }
        }

        int INF = Integer.MAX_VALUE;
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(k==i || i==j || j==k) continue;


                    if(dist[i][j]>dist[i][k]+dist[k][j] ){


                        System.out.println(-1);

                        return;
                    }
                    if(dist[i][j]==dist[i][k]+dist[k][j]){

                        arr[i][j] = INF;
                        arr[j][i] = INF;
                    }
                }

            }
        }


        int answer = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i][j] != INF)
                    answer += arr[i][j];

            }
        }


       System.out.println(answer);


    }



}
