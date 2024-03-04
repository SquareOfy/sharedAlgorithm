import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static List<int[]> blanks;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        input();

        flag = false;


        setBlank(0);



        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static void setBlank(int idx){

        if(idx==blanks.size()){
            flag = true;
            return;


        }
        int[] now = blanks.get(idx);
        for(int i=1; i<10; i++){
            map[now[0]][now[1]]=i;
            if(isPossible(now[0],now[1])) setBlank(idx+1);

            if(flag) return;
            map[now[0]][now[1]] = 0;

        }
    }

    static boolean isPossible(int r, int c){
        for(int i=0; i<9; i++){
            if(map[r][i]==map[r][c] && i!=c) return false;

            if(map[i][c]==map[r][c] && i!=r) return false;

        }

        int startR = ((r)/3)*3;
        int startC = ((c)/3)*3;

        for(int i=startR; i<startR+3; i++){
            for(int j=startC; j<startC+3; j++){
                if(map[r][c]==map[i][j] && (r!=i ||c!=j)){
                    return false;
                }
            }
        }

        return true;

    }



    static void input() throws IOException {
        map = new int[9][9];
        blanks = new ArrayList<>();
        for(int r=0; r<9; r++){
            String str = br.readLine();
            for(int c=0; c<9; c++){
                map[r][c] = str.charAt(c)-'0';
                if(map[r][c]==0) blanks.add(new int[]{r,c});
            }
        }



    }

}