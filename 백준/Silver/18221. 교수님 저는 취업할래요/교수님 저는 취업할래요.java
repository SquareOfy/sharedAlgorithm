import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static Node professor;
    static Node student;

    public static void main(String[] args) throws IOException {
        input();


        int d = (int) (Math.pow(professor.r - student.r, 2)+Math.pow(professor.c- student.c, 2));
        if(d<25) {
            System.out.println(0);
            return;
        }

        int minR = Math.min(student.r, professor.r);
        int minC = Math.min(student.c, professor.c);
        int maxR = Math.max(student.r, professor.r);
        int maxC = Math.max(student.c, professor.c);

        int cnt =0;
        for(int i=minR; i<=maxR; i++){
            for(int j=minC; j<=maxC; j++){
                if(map[i][j]==1) cnt++;
            }
        }
        System.out.println(cnt>=3 ? 1 : 0);
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());;
        map = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());

            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c]==2) student = new Node(r,c);
                if(map[r][c]==5) professor = new Node(r,c);
            }
        }
    }

    static class Node{
        int r;
        int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}