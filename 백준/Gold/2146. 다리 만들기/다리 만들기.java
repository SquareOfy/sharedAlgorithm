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
    static boolean[][] visited;
    static int answer;

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};

    public static class Node{
        int r;
        int c;
        int rank;
        Node(int r, int c, int rank){
            this.r = r;
            this.c = c;
            this.rank = rank;
        }
    }


    public static void main(String[] args) throws IOException {
        input();


        //섬들이 모두 1로 이뤄져 있으므로 다른 섬인지 구분 불가
        //섬의 번호를 1, 2, 3, .. 으로 바꾸어 섬 구분하도록 하기
        int num = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]!=0 && !visited[i][j]){
                    dfs(i, j, num);
                    num++;
                }
            }
        }



        //Queue에 r, c, rank정보가 담긴 Node 넣기
        //rank는 r,c위치의 값이 같은 섬이면 올리지 않고 섬이 아니면 올리기
        //다른 섬을 만나는 순간 최솟값 갱신하고 종료하기
        //1 - 3을 연결하느라 2-3연결에 방해될 수 있으니 섬별로 계산하기

        answer = Integer.MAX_VALUE;

        for(int i=1; i<num; i++){
            bfs(i);
        }

        System.out.println(answer);
    }

    public static void bfs(int num){
        Queue<Node> queue = new LinkedList<>();
        //visited 초기화
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], false);
        }
        //num인 섬들 다 넣기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j]==num){
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int du= now.r + dr[i];
                int dv = now.c + dc[i];

                if(du<0 || dv<0 || du>=N || dv>=N || visited[du][dv]) continue;

                if(map[du][dv]==0){
                    queue.add(new Node(du, dv, now.rank+1));
                    visited[du][dv] = true;
                }else if(map[du][dv]!=num){
                    //최솟값 갱신 후 return
                    answer = Math.min(answer, now.rank);
                    return;
                }
            }
        }
    }

    public static void dfs(int r, int c, int num){
        map[r][c] = num;
        visited[r][c] = true;

        for(int i=0; i<4; i++){
            int du = r+dr[i];
            int dv = c+dc[i];
            if(du<0 || dv<0 || du>=N || dv>=N || visited[du][dv]) continue;

            if(map[du][dv]!=0) dfs(du, dv, num);
        }
    }



    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            for(int m=0; m<N; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
    }
}