import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,P;
    static int score;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        input();

        int rank = 1;
        int idx = 0;
        boolean isPossible = true;
        for(int i=0; i<Math.min(P, N); i++){
            if(list.get(i)>score){
                rank++;
            }else if(list.get(i)<score){
                break;
            }else{
                idx = i;
            }
        }

        if(rank>P || idx==P-1) System.out.println(-1);
        else System.out.println(rank);

    }

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        
        if(N>0) st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int n=0; n<N; n++){
            list.add(Integer.parseInt(st.nextToken()));
        }

    }

}