import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Score implements Comparable<Score> {
        String name;
        int korean;
        int english;
        int math;
        public Score(String name, int korean, int english, int math){
            this.english = english;
            this.name = name;
            this.korean = korean;
            this.math = math;
        }

        @Override
        public int compareTo(Score o) {
            if(this.korean!= o.korean){
                return o.korean-this.korean;//this.korean-o.korean;
            }else if(this.english!=o.english){
                return this.english-o.english;
            }else if(this.math != o.math){
                return o.math-this.math;
            }else{
                return this.name.compareTo(o.name);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Score[] arr = new Score[N];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            arr[n] = new Score(name, korean, english, math);
        }


        Arrays.sort(arr);
        for(int n=0; n<N; n++){
            sb.append(arr[n].name).append("\n");
        }

        System.out.println(sb.toString());

    }
}