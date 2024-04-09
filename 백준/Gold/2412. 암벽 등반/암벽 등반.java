import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,T;
    static Node[] map;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(map, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y-o2.y==0) return o1.x-o2.x;
                return o1.y - o2.y;
            }
        });
        int answer = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 0;

        while(!queue.isEmpty()){

            int now = queue.poll();

            if(map[now].y ==T ) {
                answer = visited[now];
                break;
            }

            //오른쪽 보기
            for(int next =now+1; next<=N; next++){
                if(visited[next]!=0) continue;
                if(map[next].y-map[now].y>2) break; //오른쪽 더 볼 필요도 없음..
                if(Math.abs(map[next].x-map[now].x)>2) continue;
                visited[next] = visited[now]+1;;
                queue.add(next);

            }

            //왼쪽 보기
            for(int next =now-1; next>0; next--){
                if(visited[next]!=0) continue;
                if(map[now].y-map[next].y>2) break; //오른쪽 더 볼 필요도 없음..
                if(Math.abs(map[next].x-map[now].x)>2) continue;
                visited[next] = visited[now]+1;
                queue.add(next);

            }

        }


        System.out.println(answer==Integer.MAX_VALUE?-1:answer);

    }


    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new Node[N+1];
        visited = new int[N+1];
        map[0] = new Node(0,0);
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[n] = new Node(x,y);
        }
    }


    public static class Node{
        int x;
        int y;

        Node(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
}