import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int answer =0;

        for(int n=0; n<N; n++){

            //왼쪽 보기
            int left = 0;

            for(int i=0; i<n; i++){
                boolean flagLeft = true;

                //왼쪽 건물과 사이에 있는 애들 높이가 넘는지 확인하자
                for(int j=i+1; j<n; j++){

                    if(arr[j]>= function(n, arr[n], i, arr[i], j)){
                        flagLeft = false;
                        break;
                    }
                }

                if(flagLeft) left++;
            }


            //오른쪽 보기
            int right =0;
            for(int i=n+1; i<N; i++){
                boolean flagRight = true;

                //왼쪽 건물과 사이에 있는 애들 높이가 넘는지 확인하자
                for(int j=n+1; j<i; j++){

                    if(arr[j]>= function(n, arr[n], i, arr[i], j)){
                        flagRight = false;
                        break;
                    }
                }

                if(flagRight) right++;
            }

            answer = Math.max(left+right, answer);

        }

        System.out.println(answer);
    }



    public static double function(int x1, int y1, int x2, int y2, int x){
        double a = (double) (y1 - y2) /(x1-x2);


        return a*(x-x1)+y1;
    }
}