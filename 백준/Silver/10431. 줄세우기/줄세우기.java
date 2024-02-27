import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int T =Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            input();
            sb.append(t).append(" ");

            int answer = 0;
            for(int j=1; j<20; j++){
                int start = j;
                for(int k=0; k<j; k++){
                    if(arr[k]>arr[j]) {
                        start = k;
                        break;
                    }
                }

                //한칸씩 뒤로 옮기기
                if(start<j){
                    int tmp = arr[j];
                    for(int k=j-1; k>=start; k--){
                        arr[k+1] = arr[k];
                        answer++;
                    }
                    arr[start] = tmp;

                }


            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        arr = new int[20];
        for(int i=0; i<20; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

}