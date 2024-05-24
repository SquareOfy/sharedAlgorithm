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

    static int N,M;
    static int[] start;
    static int[][] map;
    static int building;
    static int broken;

    static boolean[][] visited;

    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};




    public static void main(String[] args) throws IOException {

        input();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], true, 0));
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();


            for(int i=0; i<4; i++){
                for(int j=1; j<=2; j++) {
                    if(!now.isEarthquake && j==2) continue;
                    int du = now.r + dr[i]*j;
                    int dv = now.c + dc[i]*j;

                    if (du < 0 || dv < 0 || du >= N || dv >= M) continue;

                    if (!visited[du][dv] && map[du][dv] != -1) {
                        visited[du][dv] = true;
                        if (map[du][dv] > 0) {
                            map[du][dv]--;
                            if (map[du][dv] == 1) visited[du][dv] = false;
                            //건물 무너졌으면 여진 발생
                            if (map[du][dv] == 0) {
                                queue.add(new Node(du, dv, false, 0));
                                broken++;
                            }
                        }


                    }else if(map[du][dv]==-1){
                        break;
                    }
                }



            }
        }



        System.out.println(broken+" " +(building-broken));

    }

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map= new int[N][M];
        visited = new boolean[N][M];

        building = 0;
        broken =0;
        for(int n=0; n<N; n++){
            String str = br.readLine();

            for(int m=0; m<M; m++){
                char c = str.charAt(m);

                //내진 설계가 되어있지 않은 건물
                if(c=='*'){
                    map[n][m] = 1;
                    building ++;
                }else if(c=='#') {
                    map[n][m] = 2;
                    building++;
                }
                else if(c=='@') {
                    start = new int[]{n,m};
                }else if(c=='|'){
                    map[n][m] = -1;
                }
            }
        }

    }


    static class Node{
        int r;
        int c;
        boolean isEarthquake;
        int rank;

        Node(int r, int c, boolean isEarthquake, int rank) {
            this.r = r;
            this.c = c;
            this.isEarthquake = isEarthquake;
            this.rank = rank;
        }
    }
}