import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K;

    public static class Node{
        int num;
        int rank;


        Node(int num, int rank){
            this.num = num;
            this.rank = rank;
        }



    }


    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();

        int[] line = new int[100001];
        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N,0));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            int num = now.num;
            int rank = now.rank;


            if(num==K) {
                sb.append(rank).append("\n");
                break;
            }
            if(num+1<=100000 && !visited[num+1]){
                queue.add(new Node(num+1, rank+1));
                visited[num+1] = true;
                dist[num+1] = num;
            }
            if(num-1>=0 && !visited[num-1]){
                queue.add(new Node(num-1, rank+1));
                visited[num-1] = true;
                dist[num-1]=num;
            }

            if(num*2<=100000 && !visited[num*2]){
                queue.add(new Node(num*2, rank+1));
                visited[num*2] = true;
                dist[num*2] = num;
            }
        }

        int num = K;

        Stack<Integer> stack = new Stack<>();
        while(num!=N){
            stack.add(dist[num]);
            num = dist[num];
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        sb.append(K);

        System.out.println(sb.toString());

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}