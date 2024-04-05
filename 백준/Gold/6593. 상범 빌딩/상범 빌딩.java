import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dl = new int[]{0, 0, 0, 0, -1, 1};

    static int L, R, C; //층, 행, 열
    static int[][][] map;
    static int[] start;
    static int[] end;

    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L==0 && R ==0 && C==0) {
                System.out.println(sb.toString());
                return;
            }

            map = new int[L][R][C];

            input();


            int result = bfs();

            if(result==-1) sb.append("Trapped!\n");
            else sb.append("Escaped in ").append(result).append(" minute(s).\n");


        }
    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[L][R][C];

        queue.add(new Node(start[0],start[1],start[2],0 ));
        visited[start[0]][start[1]][start[2]] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.l == end[0] && now.r == end[1] && now.c == end[2]){
                return now.rank;
            }

            for(int i=0; i<6; i++){
                int dx = now.r + dr[i];
                int dy = now.c + dc[i];
                int dz = now.l + dl[i];

                if(dx<0 || dy<0|| dz<0 || dx>=R || dy>=C || dz>=L) continue;

                if(map[dz][dx][dy]!=-1 && !visited[dz][dx][dy]){
                    queue.add(new Node(dz, dx, dy, now.rank+1));
                    visited[dz][dx][dy] = true;
                }
            }
        }

        return -1;

    }

    public static void input() throws IOException {

        for(int l=0; l<L; l++){
            for(int r=0; r<R; r++){
                String str = br.readLine();
                for(int c=0; c<C; c++){
                    char ch = str.charAt(c);
                    if(ch=='#'){
                        //지나갈 수 없음
                        map[l][r][c] = -1;
                    }else if(ch=='S'){
                        //시작지점 표시
                        start = new int[] {l,r,c};
                    }else if(ch=='E'){
                        //탈출 출구
                        end = new int[] {l,r,c};
                    }
                }
            }
            br.readLine();
        }

    }

    public static class Node{
        int l;
        int r;

        int c;
        int rank;

        Node(int l, int r, int c, int rank){
            this.l = l;
            this.r = r;
            this.c = c;
            this.rank = rank;
        }
    }
}