import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] goal;

    static Node[] problems;
    public static void main(String[] args) throws IOException {

        input();
        Arrays.sort(problems, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.k == o2.k) return o1.time-o2.time;
                return o1.k - o2.k;
            }
        });

        int before =0;
        int beforeTime=0;
        int answer =0;
        for(int n=0; n<N; n++){
            int k = problems[n].k;
            int time = problems[n].time;
            if(goal[k]==0) continue;

            //휴식 시간 계산
            if(before!=0){
                if(before<k) answer+=60;
                else if(before==k) answer+=time-beforeTime;
            }

            before = k;
            beforeTime = time;

            answer+=time;
            goal[k]--;
        }
        System.out.println(answer);

    }
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        goal = new int[6];

        problems = new Node[N];

        for(int i=1; i<=5; i++){
            goal[i] = Integer.parseInt(st.nextToken());
        }

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            problems[n] = new Node(k, time);
        }
    }

    static class Node{
        int k; //난이도
        int time;

        Node(int k, int time){
            this.k = k;
            this.time = time;
        }
    }
}