import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int answer;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int n=0; n<N; n++){
            String str = br.readLine();
            for(int m=0; m<M; m++){
                map[n][m] = str.charAt(m) -'0';
            }
        }

        int maxLen = Math.min(N,M);

        answer =0;
        for(int len = maxLen; len>=1; len--){
            //최대 정사각형 찾기
            if(findSquare(len, map, 0, 0)) {
                answer = len*len;
                break;
            }
        }

        System.out.println(answer);


//        for(int i=1; i<=maxLen; i++){
//
//        }




    }

    public static boolean findSquare(int len, int[][] map, int r, int c){
        int num = 0;
        for(int i=r; i<=N-len; i++){
            for(int j=c; j<=M-len; j++){
                num = map[i][j];
                if(map[i+len-1][j] !=num) continue;
                if(map[i][j+len-1]!=num) continue;
                if(map[i+len-1][j+len-1]!=num) continue;
                return true;
            }
        }
        return false;
    }




}