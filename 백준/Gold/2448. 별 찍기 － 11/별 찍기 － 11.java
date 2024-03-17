import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int k = N % 3;
        //k줄만큼 삼각형이 생김. 1줄에 3개의 행 필요
        //열은 k개 만큼 삼각형이 생기고 1개의 삼각형은 5개의 열 필요. 삼각형이 하나 연결 될 때마다 사이에 1칸 필요
        // k*5+k-1
         map = new char[N][2 * N - 1];

        for(int i=0; i<map.length; i++){
            Arrays.fill(map[i], ' ');
        }

        draw(N, 0, N-1);

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }


    public static void draw(int n, int r, int c) {
        if (n == 3) {
            map[r][c] = '*';
            map[r+1][c-1] = map[r+1][c+1] = '*';
            for(int i=c-2; i<=c+2; i++){
                map[r+2][i] = '*';
            }

            return;
        }

        int size = n/2;
        draw(size, r, c);
        draw(size, r+size, c-size);
        draw(size, r+size, c+size);


    }
}