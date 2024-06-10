import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt =0;

        int answer =0;

        boolean[] visited = new boolean[n+1];
        outer : for(int i=2; i<=n; i++){
            if(visited[i]) continue;
            int idx = 1;

            while(idx*i <=n){
                if(!visited[idx*i]){
                    cnt++;
                    visited[idx*i] = true;
                }

                if(cnt==k) {
                    answer = idx*i;
                    break outer;
                }

                idx++;


            }
        }

        System.out.println(answer);
    }
}