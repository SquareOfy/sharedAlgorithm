import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        input();
        Arrays.sort(arr);

        int crossPoint = 0;
        for(int i=1; i<N; i++){
            if(arr[i-1]*arr[i]<0){
                crossPoint = i;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2)-Math.abs(o1);
            }
        });

        int max = 0;
        for(int i=0; i<N; i++){
            pq.add(arr[i]);
            max = Math.max(Math.abs(arr[i]), max);

        }

        int answer=0;
        int plusCnt =0;
        int minusCnt = 0;

        int plusMax = 0;
        int minusMax = 0;
        while(!pq.isEmpty()){
            int now = pq.poll();
            if(now>0){
                plusCnt++;
                plusMax = Math.max(now, plusMax);
                if(plusCnt == M){
                    answer += plusMax*2;
                    plusMax =0;
                    plusCnt = 0;
                }
            }else{
                minusCnt++;
                minusMax = Math.max(Math.abs(now),minusMax);
                if(minusCnt == M){
                    answer += minusMax*2;

                    minusMax =0;
                    minusCnt = 0;
                }
            }
        }

        if(minusCnt!=0){
            answer += minusMax*2;
        }
        if(plusCnt !=0){
            answer+=plusMax*2;
        }
        answer -= max;
        System.out.println(answer);



    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
    }
}