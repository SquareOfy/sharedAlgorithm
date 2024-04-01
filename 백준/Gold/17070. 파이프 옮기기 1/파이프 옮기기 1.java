import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static int count;

    public static class Node{
        int startR;
        int startC;
        int endR;
        int endC;

        Node(int startR, int startC, int endR, int endC){
            this.startR=startR;
            this.startC=startC;
            this.endR=endR;
            this.endC=endC;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        //dfs
        count =0;

        dfs(new Node(0,0, 0,1));

        System.out.println(count);

    }

    public static void dfs(Node node){

        if(node.endR==N-1 && node.endC==N-1) {
            count++;
            return;
        }
        int nextR =0;
        int nextC =0;

        boolean isDiagnol = node.startR+1==node.endR && node.startC+1==node.endC;
        //가로 방향 또는 대각방향만 가로 방향으로 밀기
        if(node.startR==node.endR || isDiagnol ) {
            //가능한지 보기
            nextR = node.endR;
            nextC = node.endC + 1;

            if (nextC >= 0 && nextC < N && map[nextR][nextC] == 0) {
                dfs(new Node(node.endR, node.endC, nextR, nextC));
            }
        }


            //세로방향 또는 대각방향만 세로 방향으로 밀기
        if(node.startC== node.endC  || isDiagnol){
            nextR = node.endR+1;
            nextC = node.endC;
            if(nextR >=0 && nextR<N && map[nextR][nextC]==0){
                dfs(new Node(node.endR, node.endC, nextR,nextC));
            }

        }

        //대각으로 밀기
        nextR = node.endR+1;
        nextC = node.endC+1;

        if(nextR<N && nextC <N){
            if(map[nextR][node.endC]==0 && map[node.endR][nextC]==0 && map[nextR][nextC]==0){
                dfs(new Node(node.endR, node.endC, nextR, nextC));
            }

        }




    }


    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}