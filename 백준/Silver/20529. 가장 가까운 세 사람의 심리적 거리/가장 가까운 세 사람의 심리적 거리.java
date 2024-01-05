import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int min ;
    static int N;
    static String[] mbti;
    static String[] selected;
    static boolean[] visitied;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            N= Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            if(N>32){
                System.out.println(0);
                
            }else{
                min = Integer.MAX_VALUE;
                mbti = new String[N];
                visitied= new boolean[N];
                selected = new String[3];
                for(int n=0; n<N; n++){
                    mbti[n] = st.nextToken();
                }

                comb(0, 0);
                System.out.println(min);
            }

          

        }

    }


    public static void comb(int cnt, int idx){
        if(min == 0) return;
        if(cnt==3){
            min = Math.min(min, calculateD());
            return;
        }

        for(int i=idx; i<N; i++){
            if(!visitied[i]){
                selected[cnt] = mbti[i];
                visitied[i] = true;
                comb(cnt+1, i+1);
                visitied[i] = false;
            }

        }
    }

    public static int calculateD(){

        int result =0;

        for(int i=0; i<3; i++){
            for(int j=i+1; j<3; j++){
                for(int k=0; k<4; k++){
                    if(selected[i].charAt(k)!=selected[j].charAt(k)) result++;
                }
            }
        }



        return result;

    }
}