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
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] map;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int answer;

    static class Moving{
        int count;
        int[][] map;

        Moving(int count ,int[][] map){
            this.count = count;
            this.map = map;
        }
    }

    public static void main(String[] args) throws IOException {

        input();
        Queue<Moving> queue = new LinkedList<>();

        queue.add(new Moving(0, map));

        while(!queue.isEmpty()){

            Moving now = queue.poll();


            int cnt = now.count;

            if(cnt==5) {
                continue;
            }

            int[][] tmp1 = new int[N][N];
            int[][] tmp2 = new int[N][N];
            int[][] tmp3 = new int[N][N];
            int[][] tmp4 = new int[N][N];
            for(int i=0; i<N; i++){
                tmp1[i] = now.map[i].clone();
                tmp2[i] = now.map[i].clone();
                tmp3[i] = now.map[i].clone();
                tmp4[i] = now.map[i].clone();
            }


            //위로 밀기
            //0이 있는 공간 없이 당기기
            for(int r=0; r<N-1; r++){
                for(int c=0; c<N; c++){
                    //내 자리가 0이면 아래 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp1[r][c]==0){
                        int idx = r; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=r+1; k<=N-1; k++){
                            if(tmp1[k][c]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp1[r][c] = tmp1[idx][c];
                        tmp1[idx][c] = 0;
                    }
                }
            }
            //아래 행을 보고 합칠 수 있으면 합치기
            for(int r=0; r<N-1; r++){
                for(int c=0; c<N; c++){
                    if(tmp1[r][c]==tmp1[r+1][c]){
                        tmp1[r][c] *=2;
                        tmp1[r+1][c] = 0;
                        answer = Math.max(answer, tmp1[r][c]);
                    }
                }
            }
            //다시 0이 없도록 빈공간 당기기
            for(int r=0; r<N-1; r++){
                for(int c=0; c<N; c++){
                    //내 자리가 0이면 아래 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp1[r][c]==0){
                        int idx = r; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=r+1; k<=N-1; k++){
                            if(tmp1[k][c]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp1[r][c] = tmp1[idx][c];
                        tmp1[idx][c] = 0;
                    }
                }
            }


            queue.add(new Moving(cnt+1, tmp1));


            //아래로 밀기
            //tmp reset


            for(int r=N-1; r>0; r--){
                for(int c=0; c<N; c++){
                    //내 자리가 0이면 위의 값 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp2[r][c]==0){
                        int idx = r; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=r-1; k>=0; k--){
                            if(tmp2[k][c]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp2[r][c] = tmp2[idx][c];
                        tmp2[idx][c] = 0;
                    }
                }
            }
            //아래 행을 보고 합칠 수 있으면 합치기
            for(int r=N-1; r>0; r--){
                for(int c=0; c<N; c++){
                    if(tmp2[r][c]==tmp2[r-1][c]){
                        tmp2[r][c] *=2;
                        tmp2[r-1][c] = 0;
                        answer = Math.max(answer, tmp2[r][c]);
                    }
                }
            }
            //다시 0이 없도록 빈공간 당기기
            for(int r=N-1; r>0; r--){
                for(int c=0; c<N; c++){
                    //내 자리가 0이면 위의 값 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp2[r][c]==0){
                        int idx = r; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=r-1; k>=0; k--){
                            if(tmp2[k][c]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp2[r][c] = tmp2[idx][c];
                        tmp2[idx][c] = 0;
                    }
                }
            }
            queue.add(new Moving(cnt+1, tmp2));


            //왼쪽으로 밀기

            for(int c=0; c<N-1; c++){
                for(int r=0; r<N; r++){
                    //내 자리가 0이면 아래 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp3[r][c]==0){
                        int idx = c; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=c+1; k<=N-1; k++){
                            if(tmp3[r][k]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp3[r][c] = tmp3[r][idx];
                        tmp3[r][idx] = 0;
                    }
                }
            }
            //아래 행을 보고 합칠 수 있으면 합치기
            for(int c=0; c<N-1; c++){
                for(int r=0; r<N; r++){
                    if(tmp3[r][c]==tmp3[r][c+1]){
                        tmp3[r][c] *=2;
                        tmp3[r][c+1] = 0;
                        answer = Math.max(answer, tmp3[r][c]);
                    }
                }
            }
            //다시 0이 없도록 빈공간 당기기
            for(int c=0; c<N-1; c++){
                for(int r=0; r<N; r++){
                    //내 자리가 0이면 아래 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp3[r][c]==0){
                        int idx = c; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=c+1; k<=N-1; k++){
                            if(tmp3[r][k]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp3[r][c] = tmp3[r][idx];
                        tmp3[r][idx] = 0;
                    }
                }
            }
            queue.add(new Moving(cnt+1, tmp3));




            //오른쪽으로 밀기

            for(int c=N-1; c>0; c--){
                for(int r=0; r<N; r++){
                    //내 자리가 0이면 아래 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp4[r][c]==0){
                        int idx = c; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=c-1; k>=0; k--){
                            if(tmp4[r][k]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp4[r][c] = tmp4[r][idx];
                        tmp4[r][idx] = 0;
                    }
                }
            }
            //아래 행을 보고 합칠 수 있으면 합치기
            for(int c=N-1; c>0; c--){
                for(int r=0; r<N; r++){
                    if(tmp4[r][c]==tmp4[r][c-1]){
                        tmp4[r][c] *=2;
                        tmp4[r][c-1] = 0;
                        answer = Math.max(answer, tmp4[r][c]);
                    }
                }
            }
            for(int c=N-1; c>0; c--){
                for(int r=0; r<N; r++){
                    //내 자리가 0이면 아래 중 0이 아닌 값을 찾아서 내 자리에 두기
                    if(tmp4[r][c]==0){
                        int idx = c; //target idx
                        //내 자리로 옮길 행 위치 고르기
                        for(int k=c-1; k>=0; k--){
                            if(tmp4[r][k]!=0) {
                                idx = k;
                                break;
                            }
                        }
                        tmp4[r][c] = tmp4[r][idx];
                        tmp4[r][idx] = 0;
                    }
                }
            }
            queue.add(new Moving(cnt+1, tmp4));



        }

        System.out.println(answer);
    }


    public static void input() throws IOException {
        N= Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<N; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
                answer = Math.max(map[n][m], answer);

            }


        }
    }
}