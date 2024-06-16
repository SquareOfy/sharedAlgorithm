import com.sun.jndi.ldap.ext.StartTlsResponseImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static Node start, end;
    static Node[] arr;
    static int distance ;
    public static void main(String[] args) throws IOException {

        input();

        int startDistance =  Math.abs(start.x - arr[1].x)+ Math.abs(start.y-arr[1].y);
        int endDistance = Math.abs(end.x-arr[N-2].x)+Math.abs(end.y-arr[N-2].y);

        distance += startDistance;


        for(int n=2; n<=N-2; n++){
            distance += Math.abs(arr[n-1].x - arr[n].x)+Math.abs(arr[n-1].y-arr[n].y);
        }

        distance+= endDistance;

        int answer = distance;

        for(int n=1; n<=N-2; n++){
            int tmp = distance;
            //앞에 연결된 거리 차감
            if(n==1){
                tmp -= startDistance;
            }else{
                tmp -=Math.abs(arr[n-1].x - arr[n].x)+Math.abs(arr[n-1].y-arr[n].y);
            }

            //뒤 거리 차감
            if(n==N-2){
                tmp -= endDistance;
            }else{
                tmp -=Math.abs(arr[n+1].x - arr[n].x)+Math.abs(arr[n+1].y-arr[n].y);
            }

            //앞 뒤 연결하기
            if(n==1){
                tmp+= Math.abs(start.x - arr[n+1].x)+Math.abs(start.y - arr[n+1].y);
            }else if(n==N-2){
                tmp+= Math.abs(end.x - arr[n-1].x)+Math.abs(end.y-arr[n-1].y);
            }else{
                tmp+=Math.abs(arr[n-1].x-arr[n+1].x)+Math.abs(arr[n-1].y-arr[n+1].y);
            }

            answer = Math.min(tmp, answer);
        }

        System.out.println(answer);

    }

    static void input() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        arr = new Node[N-1];
        for(int n=1; n<N-1; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[n] = new Node(x, y);
        }

        st = new StringTokenizer(br.readLine());
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}