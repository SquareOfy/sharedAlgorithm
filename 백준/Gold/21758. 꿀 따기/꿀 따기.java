import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static boolean[] visited;
    static int answer;

    static int beeHome;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();

        selected = new int[2];
        answer = Integer.MIN_VALUE;
        pickBeePlace(0, 0);
        System.out.println(answer);
    }

    static void pickBeePlace(int cnt, int idx){

        if(cnt==2){
            //벌자리 다 골랐으면 벌통 자리 정해서 최댓값 계산
            pickBeeHome();
            return;
        }

        for(int i = idx; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = i;
                pickBeePlace(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }
    static  void pickBeeHome(){

        for(int i=0; i<N; i++){
            //벌이 없으면 벌집 놓고 계산
            int cnt =0;
            if(!visited[i]){
                beeHome = i;
                //벌 한마리씩 계산
                for(int j=0; j<2; j++){
                    int bee = selected[j];
                    //벌집이 왼쪽에 위치
                    if(bee>i) {
                        for(int k=i; k<bee; k++ ){
                            if(!visited[k]){

                                cnt+= arr[k];
                            }
                        }
                    }else{ //벌집이 오른쪽에 위치
                        for(int k=bee+1; k<=i; k++){
                            if(!visited[k]) cnt+= arr[k];

                        }
                    }

                }
                answer = Math.max(answer, cnt);
            }
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
    }
}