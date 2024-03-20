import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int W,H;
    static int[][] map;
    static boolean [][] visited;

    static int[] start;
    static List<int[]> fireList;

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
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            input();

            Queue<int[]> queue = new LinkedList<>();
            for(int[] fire: fireList){
                queue.add(fire);
                visited[fire[0]][fire[1]] = true;
            }

            //불 번지게 하기
            while(!queue.isEmpty()){
                int[] now = queue.poll();

                int rank = map[now[0]][now[1]];
                for(int i=0; i<4; i++){
                    int du = now[0] + dr[i];
                    int dv = now[1] + dc[i];

                    if(du<0 || dv<0 || du>=H || dv>=W) continue;
                    if(map[du][dv]==0 && !visited[du][dv]){
                        map[du][dv] =rank+1;
                        visited[du][dv]=true;
                        queue.add(new int[] {du,dv});
                    }
                }
            }


            int time = Integer.MAX_VALUE;
            //상근이 이동시키기
            for(int i=0; i<H; i++){
                Arrays.fill(visited[i], false);
            }

                Queue<Node> dogQ = new LinkedList<>();
                dogQ.add(new Node(start[0], start[1], 1));
                visited[start[0]][start[1]] = true;


                outer:
                while (!dogQ.isEmpty()) {
                    Node now = dogQ.poll();




                    for (int i = 0; i < 4; i++) {
                        int du = now.r + dr[i];
                        int dv = now.c + dc[i];

                        if (du < 0 || dv < 0 || du >= H || dv >= W) {
                            time = Math.min(now.rank, time);
                            break outer;
                        }
                        if ((map[du][dv]==0||(map[du][dv] != -1 && map[du][dv] > now.rank + 1 ))&& !visited[du][dv]) {
                            visited[du][dv] = true;
                            dogQ.add(new Node(du, dv, now.rank + 1));
                        }
                    }


            }
            if(time==Integer.MAX_VALUE) sb.append("IMPOSSIBLE\n");
            else sb.append(time).append("\n");



        }
        System.out.println(sb.toString());

    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        start = new int[2];
        visited = new boolean[H][W];

        fireList = new ArrayList<>();

        for(int h=0; h<H; h++){
            String str = br.readLine();
            for(int w=0; w<W; w++){
                if(str.charAt(w)=='#'){
                    map[h][w] = -1;
                }else if(str.charAt(w)=='.'){
                    map[h][w] = 0;
                }else if(str.charAt(w)=='@'){
                    start[0] = h;
                    start[1]= w;
                }else{
                    map[h][w] = 1;
                    fireList.add(new int[] {h,w});
                }
            }
        }
    }
}