import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        int[] arr = new int[N];
        //사람이면 1 햄버거면 0
        for(int i=0; i<N; i++){
            arr[i] = str.charAt(i)=='H' ? 0 : 1;
        }

        boolean[] visited = new boolean[N];
        int cnt =0;
        outer: for(int i=0; i<N; i++){
            if(arr[i]==1) {

                //좌 K개
                for(int j=K; j>=1; j--){
                    if (i -j >= 0 && arr[i - j] == 0 && !visited[i -j]) {
                        visited[i -j] = true;
                        cnt++;
                        continue outer; 
                    }
                }
                for (int j = 1; j <= K; j++) {


                    //우 K개
                    if(i+j<N && arr[i+j]==0 && !visited[i+j]){
                        visited[i+j] = true;

                        cnt++;
                        continue outer;
                    }
                }

            }
        }

        System.out.println(cnt);



    }

}