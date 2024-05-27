import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static String str;
    static int[] arr;
    static int red;
    static int blue;


    public static void main(String[] args) throws IOException {

        input();


        int answer = Math.min(red, blue);

        int cnt = 0;
        //왼쪽에 R이 이미 위치해있고, R을 왼쪽에 위치하게 옮길 것.
        if(arr[0]==0){

            //R 움직이기
            int side = checkLeft(0);
            //R을 움직임
            answer = Math.min(answer, red-side);
        }else if(arr[0]==1){//왼쪽에 blue위치하면 B를 왼쪽에 위치하게 B를 이동시켜 볼 것
            int side = checkLeft(1);
            answer = Math.min(answer, blue-side);
        }

        //R이 오른쪽에 이미 위치해있으면 R을 오른쪽에 위치하게 옮겨볼 것
        if(arr[N-1]==0){
            int side = checkRight(0);
            answer = Math.min(answer, red-side);
        }else if(arr[N-1]==1){
            int side = checkRight(1);
            answer= Math.min(answer, blue-side);
        }

        System.out.println(answer);



    }

    public static int checkLeft(int color){
        int side = 0;
        for(int i=0; i<N; i++){
            if(arr[i]==color) side++;
            else return side;
        }
        return side;
    }

    public static int checkRight(int color){
        int side =0;
        for(int i=N-1; i>=0; i--){
            if(arr[i]==color) side++;
            else return side;
        }
        return side;
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        str = br.readLine();
        for(int i=0; i<N; i++){
            arr[i] = str.charAt(i)=='R' ? 0 : 1;
            if(arr[i] == 0 ) red++;
            else blue++;
        }
    }
}