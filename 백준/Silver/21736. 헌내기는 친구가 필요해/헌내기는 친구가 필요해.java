import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        int[] start = new int[2];
        for(int n=0; n<N; n++){
            String str = br.readLine();
            for(int m=0; m<M; m++){
                char input = str.charAt(m);
                if(input == 'I') {
                    map[n][m] = 1;
                    start[0] = n;
                    start[1] = m;
                }
                else if(input =='X') map[n][m] = -1;
                else if(input == 'P') map[n][m] = 2;

            }
        }


        Queue<int[]> queue = new LinkedList<>();

        int[] dr = new int[] {-1, 1, 0, 0};
        int[] dc = new int[] {0, 0, -1, 1};

        int count = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i=0; i<4; i++){
                int[] next = new int[] {now[0] + dr[i], now[1] + dc[i]};

                if(next[0]>=0 && next[0] < N && next[1] >=0 && next[1]<M){
                    if(!visited[next[0]][next[1]] && map[next[0]][next[1]]!=-1){
                        visited[next[0]][next[1]] = true;

                        queue.add(next);

                        if(map[next[0]][next[1]]==2){

                            count ++;

                       }

                    }
                }
            }
        }

        if(count ==0) System.out.println("TT");
        else System.out.println(count);


    }
}