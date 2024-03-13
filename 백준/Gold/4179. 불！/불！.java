import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R,C;
    static int[][] map;
    static Queue<Node> fireQ;
    static int[] start;


    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, -1, 0,  1};
    static int INF;



    public static class Node {
        int r;
        int c;

        Node( int r, int c ){
            this.r = r;
            this. c = c;
        }
    }

    public static class Person {
        int r;
        int c;
        int time;
        Person(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time =time;
        }
    }


    public static void main(String[] args) throws IOException {

        input();

        spreadFire();

        int answer = movePerson();

        System.out.println(answer==-1 ? "IMPOSSIBLE" : answer);




    }
    public static int movePerson(){
        int answer = Integer.MAX_VALUE;
        Queue<Person> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(new Person(start[0], start[1], 0 ));
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            Person person = queue.poll();

            for(int i=0; i<4; i++){
                int du = person.r + dr[i];
                int dv = person.c + dc[i];


                //탈출하면 그 때 시간 return
                if(du<0 || dv<0 || du>=R || dv>=C){
                    return person.time+1;
                }

                if(!visited[du][dv] && map[du][dv]!=INF && (map[du][dv] > person.time+1 || map[du][dv]==-1)){
                    visited[du][dv] = true;
                    queue.add(new Person(du, dv, person.time+1));
                }

             }
        }

        return -1;

    }
    public static void spreadFire(){

        while(!fireQ.isEmpty()){
            Node now = fireQ.poll();
            int time = map[now.r][now.c];
            for(int i=0; i<4; i++){
                int du = now.r + dr[i];
                int dv = now.c + dc[i];

                if(du<0 || dv<0 || du>=R || dv>=C || map[du][dv]==INF) continue;

                if(map[du][dv]==-1){
                    map[du][dv] = time+1;
                    fireQ.add(new Node(du, dv));
                }

            }
        }
    }


    public static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        INF =  Integer.MAX_VALUE;
        map = new int[R][C];
        fireQ = new LinkedList<>();
        start = new int[2];

        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0 ;c<C; c++){
                char item = str.charAt(c);
                if(item =='#') map[r][c] =INF;
                else if(item == 'J'){
                    start[0] = r;
                    start[1] = c;
                    map[r][c] = -1;

                }else if(item=='F'){
                    map[r][c] = 0;
                    fireQ.add(new Node(r, c));
                }else{
                    map[r][c] = -1;
                }
            }
        }


    }
}