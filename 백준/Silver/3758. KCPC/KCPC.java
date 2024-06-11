import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n,k,myId,m;

    static Entry[] arr;
    static int[] cntArr;
    static int[][] scores;
    static int[] recent;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int t=0; t<T; t++){
            input();

            Entry[] sumArr = new Entry[n];

            for(int i=0; i<n; i++){
                int sum = 0;
                for(int j=1; j<=k; j++){
                    sum += scores[j][i+1];
                }
                sumArr[i] = new Entry(i+1,sum);
            }

            Arrays.sort(sumArr, new Comparator<Entry>() {
                @Override
                public int compare(Entry o1, Entry o2) {
                    if(o1.sum==o2.sum){
                        if(cntArr[o1.id]==cntArr[o2.id]){
                            return recent[o1.id]-recent[o2.id];
                        }

                        return cntArr[o1.id]-cntArr[o2.id];
                    };

                    return o2.sum-o1.sum;
                }
            });


            int rank = 1;
            boolean[] visited = new boolean[n+1];
            for(int i=0; i<n; i++){
                if(sumArr[i].id==myId){
                    break;
                }
                if(!visited[sumArr[i].id]){
                    rank++;
                    visited[sumArr[i].id]=true;
                }
            }


            sb.append(rank).append("\n");


        }

        System.out.println(sb.toString());
    }


    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        myId = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cntArr = new int[n+1];
        scores = new int[k+1][n+1];
        recent = new int[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int id = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            scores[num][id] = Math.max(score, scores[num][id]); //최종 점수 갱신
            recent[id] = i; //가장 최근 제출 시간 기록
            cntArr[id] ++; //문제 제출 횟수 기록

        }

    }

    static class Entry{
        int id;
        int sum;

        Entry(int id, int sum){
            this.id = id;
            this.sum = sum;
        }

    }
}