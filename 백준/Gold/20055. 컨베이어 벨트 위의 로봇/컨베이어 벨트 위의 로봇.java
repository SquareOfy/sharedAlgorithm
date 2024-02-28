import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        input();
        int step = 1;
        int up = 1;
        int down = N;
        int cnt = 0;
        int[] robot = new int[2*N+1];
        Queue<Integer> queue = new LinkedList<>();
        outer : while(cnt<K) {

            //1. 벨트 회전 : up과 down -- 후 0이면 2N.
            up = (up-1)%(2*N);
            if (up == 0) up = 2 * N;
            down= (down-1)%(2*N);
            if (down == 0) down = 2 * N;


            //2. 가장 먼저 벨트에 올라간 로봇부터 회전하는 방향으로 한칸 이동(가능하면)
            robot[down] = 0;
            int size = queue.size();

            while (size >0) {
                //먼저 올린 벨트 순으로 그 벨트의 현재 위치

                int now = queue.poll();
                size--;


                if(now==down) continue;


                //회전하는 방향의 로봇 유무와 내구도 확인 후 로봇 이동(내구도--)
                int next = (now+1)%(2*N) == 0 ? 2 * N : (now+1)%(2*N);




                if (robot[next] == 0 && arr[next] > 0) {
                    if(next!=down) robot[next]++;
                    robot[now]--;
                    arr[next]--;
                    if (arr[next] == 0) cnt++;
                    if(cnt==K) break outer;
                    if(next!=down) queue.add(next);
                }else{
                    queue.add(now);
                }





            }



            //3. 올리는 위치의 내구도 확인 후 가능하면 로봇 올리기

            if (arr[up] > 0) {
                arr[up]--;
                robot[up]++;
                queue.add(up);
                if (arr[up] == 0) cnt++;
                if(cnt==K) break;


            }


            step++;

        }

        System.out.println(step);



    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N*2+1];
        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=2*N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

    }
}