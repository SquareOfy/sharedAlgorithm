import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[] reverse;
    static int[] sumArr;
    static boolean[] visited;
    static int answer;

    static int beeHome;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();

        selected = new int[2];
        answer = Integer.MIN_VALUE;
        sumArr = arr.clone();
        reverse = arr.clone();

        for(int i=1; i<=N; i++){
            sumArr[i] += sumArr[i-1];
        }



        pickBeePlace(0, 1);
        System.out.println(answer);
    }

    static void pickBeePlace(int cnt, int idx){

        if(cnt==2){
            //벌자리 다 골랐으면 벌통 자리 정해서 최댓값 계산
            pickBeeHome();

            return;
        }

        for(int i = idx; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = i;
                pickBeePlace(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }
    static  void pickBeeHome(){

        for(int i=1; i<=N; i++){
            //벌이 없으면 벌집 놓고 계산
            int cnt =0;
            if(!visited[i]){
                //벌 한마리씩 계산
                for(int j=0; j<2; j++){
                    int bee = selected[j];
                    int other = selected[(j+1)%2];
                    //벌집이 왼쪽에 위치
                    if(i<bee) {
                        cnt+= sumArr[bee-1]-sumArr[i-1];
                        if(other<bee && i<other) cnt-= arr[other];
                    }else{ //벌집이 오른쪽에 위치
                        cnt += sumArr[i]-sumArr[bee];
                        if(other>bee && i>other) cnt-= arr[other];

                    }

                }

                answer = Math.max(answer, cnt);
            }
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];
        reverse = new int[N+1];
        sumArr = new int[N+1];
        for(int n=1; n<=N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
    }
}