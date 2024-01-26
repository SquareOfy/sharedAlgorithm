import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L, R;

    static int[][] map;
    static int[][] check;
    static boolean[][] visited;

    static int[] dr = new int[] {-1,1, 0,0};
    static int[] dc = new int[] {0,0, -1, 1};

    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        check = new int[N][N];

        visited = new boolean[N][N];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combine();
        System.out.println(answer);




    }


    public static void combine() {

        Queue<int[]> queue = new LinkedList<>();

        //연합하기 !

        //i행 j열의 원소의 상,하,좌,우를 보고 차이가 인구이동이 가능한지 check
        //가능하다면 국경선 해제(idx를 check 배열에 넣기) + visited 배열 true
        //idx로 visited 배열 사용해도 되려나?
        while (true) {

            for(int i=0; i<N; i++){
                Arrays.fill(check[i], 0);
                Arrays.fill(visited[i], false);
            }
            boolean isCombine = false;
            int idx = 1;
            Queue<int[]> idxQ = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;

                    check[i][j] = idx;
                    visited[i][j] = true;

                    idxQ.add(new int[] {i,j});

                    while(!idxQ.isEmpty()){
                        int[] now = idxQ.poll();
                        for (int k = 0; k < 4; k++) {
                            int du = now[0] + dr[k];
                            int dv = now[1] + dc[k];

                            if (du < 0 || dv < 0 || du >= N || dv >= N) continue;
                            int gap = Math.abs(map[now[0]][now[1]] - map[du][dv]);
                            if ( !visited[du][dv] && gap >= L && gap <= R) {
                                idxQ.add(new int[] {du,dv});
                                check[du][dv] = idx;
                                visited[du][dv] = true;
                                if(!isCombine) {
                                    isCombine = true;
                                }
                            }
                        }

                    }
                    idx++;


                }
            }

            if(!isCombine) break;

            for(int i=0; i<N; i++){
                Arrays.fill(visited[i], false);
            }

            //연합한 지역들의 인구수 정리


            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j]) continue;

                    List<int[]> list = new ArrayList<>();

                    queue.add(new int[] {i, j});
                    visited[i][j] = true;

                    int num = check[i][j];


                    list.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] now = queue.poll();

                        for(int k=0; k<4; k++){
                            int du = now[0]+dr[k];
                            int dv = now[1]+dc[k];

                            if(du<0 || dv<0 || du>=N || dv>=N || check[du][dv] != num) continue;

                            if(!visited[du][dv]){
                                int[] node = new int[] {du,dv};
                                list.add(node);
                                queue.add(node);
                                visited[du][dv] = true;
                            }
                        }

                    }

                    int sum =0 ;
                    int cnt = list.size();
                    for (int[] node : list) {
                        sum += map[node[0]][node[1]];

                    }

                    int population = sum / cnt;
                    for (int[] node : list) {

                        map[node[0]][node[1]] = population;

                    }



                }
            }





            answer ++;

        }
    }


}