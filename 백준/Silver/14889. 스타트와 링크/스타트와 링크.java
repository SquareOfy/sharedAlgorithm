import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    static int min;

    static int N;
    static int[][] map;
    static List<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        map = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());

            }
        }

        min = Integer.MAX_VALUE;
        list = new ArrayList<>();

        combination(0, 0);

        System.out.println(min);

    }

    public static void combination(int num, int cnt){

        if(cnt==N/2){
            getPower();
            return;
        }

        for(int i=num; i<N; i++){
            if(list.isEmpty() || list.get(list.size()-1)<i) {
                visited[i] = true;
                list.add(i);

                combination(num + 1, cnt + 1);
                visited[i] = false;
                list.remove(list.size() - 1);

            }
        }
    }

    public static void getPower(){
        int power1 = 0;
        int power2 = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i]&&visited[j]){
                    power1 += map[i][j]+map[j][i];
                }else if(!visited[i]&&!visited[j]){
                    power2 += map[i][j] +map[j][i];
                }

            }
        }

        min = Math.min(min, Math.abs(power1-power2));

    }
}
