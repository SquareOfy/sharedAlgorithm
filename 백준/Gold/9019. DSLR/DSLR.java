import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[] order = new String[] {"D", "S", "L", "R"};

    static boolean[] visited;


    public static class DSLR {
        int num;
        String order;

        public DSLR(int num, String order){
            this.num = num;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            visited = new boolean[10000];
            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            String result = bfs(num, target,t);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());

    }


    public static String bfs(int num, int target, int t){
        Queue<DSLR> queue = new LinkedList<>();

        queue.add(new DSLR(num, ""));
        visited[num] = true;

       while(!queue.isEmpty()){
           DSLR now = queue.poll();
           int n = now.num;
           if(n==target) return now.order;

           //D
           if(!visited[(n*2)%10000]){
               queue.add(new DSLR((n*2)%10000, now.order+"D"));
               visited[(n*2)%10000] = true;
           }
           //S
            if( !visited[(n+9999)%10000]){
               queue.add(new DSLR((n+9999)%10000, now.order+"S"));
               visited[(n+9999)%10000] = true;
           }


           int left = ((n%1000)*10) + (n/1000);
           int right = (n/10)+ (n%10)*1000;


           //L
           if(!visited[left]) {
               queue.add(new DSLR(left, now.order+"L"));
               visited[left]=true;
           }
           //R
           if(!visited[right]){
               queue.add(new DSLR(right, now.order+"R"));
               visited[right]=true;
           }




       }
       return "ERROR";
    }



}