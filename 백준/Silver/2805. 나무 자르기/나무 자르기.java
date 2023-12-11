import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        long[] tree = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            tree[n] = Integer.parseInt(st.nextToken());
        }

        long max = Arrays.stream(tree).max().getAsLong();
        long min = 0;
        long target = (max+min) /2;


        long height = 0;


        while(min<=max){
            target = (max+min)/2;


            height =0;
            for(int i=0; i<N; i++){
                if(tree[i]>target) height += tree[i] - target;

            }


            if(height-M>0) {
                min = target+1;

            }
            else if(height-M<0){
                max = target-1;
            }
            else break;


        }

        System.out.println((min+max)/2);
    }
}