import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static int[] selected;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {

        input();

        //1~9까지 브루트포스로 selected에 넣기. 단. 1번은 반드시 4번째 !!
        selected = new int[10];
        visited = new boolean[10];
        selected[4] = 1;
        max = 0;
        dfs(1, 2);

        System.out.println(max);




    }

    public static void dfs(int cnt, int idx){
        if(cnt==10){
            //selected에 있는 애들 가지고 최대점수 계산
            baseball();

            return;

        }

        for(int i=2; i<=9; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = i;
                if (cnt + 1 == 4) {
                    dfs(cnt + 2, i + 1);
                } else {
                    dfs(cnt + 1, i + 1);
                }
                visited[i] = false;
            }
        }

    }

    public static void baseball(){
        int inning = 0;
        int idx = 1; //시작 선수 번호



        Queue<int[]> queue = new LinkedList<>();//현재 1,2,3루에 있는 선수 번호
        //selected의 순서대로 이닝을 돈다

        int score = 0;
        int out = 0;
        while(inning<N) {



            int result = map[inning][selected[idx]-1]; //현재 선수의 결과

            if (result >= 1) {

                score += run(queue, result, selected[idx]);
                idx++;

                if (idx == 10) idx = 1;
            } else {
                out++;
                idx++;
                if (idx == 10) idx = 1;
                if (out == 3) {
                    out = 0;
                    inning++;
                    queue.clear();
                    if (inning == N) {
                        max = Math.max(max, score);
                        return;
                    }
                }
            }
        }



    }

    public static int run(Queue<int[]> queue, int num, int batter){

        int score =0;
        int size = queue.size();
        for(int i=0; i<size; i++){
            int[] runner = queue.poll();
            runner[1] += num;
            if(runner[1]>=4){
                score++;
            }else{
                queue.add(runner);
            }
        }

        if(num==4) score++;
        else queue.add(new int[]{batter, num});
        return score;
    }


    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][9];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}