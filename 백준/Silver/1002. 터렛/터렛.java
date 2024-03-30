import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            Node a = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int da = Integer.parseInt(st.nextToken());

            Node b = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int db = Integer.parseInt(st.nextToken());

            if(a.r==b.r && a.c == b.c && da==db) {
                sb.append(-1).append("\n");
                continue;
            }

            double dCenter = Math.sqrt(Math.pow(a.r-b.r,2)+Math.pow(a.c-b.c, 2));
            double gapR = Math.abs(da-db);

            if(dCenter==gapR || dCenter==da+db) sb.append(1);
            else if(dCenter>da+db || dCenter<gapR) sb.append(0);
            else if(dCenter > gapR) sb.append(2);
            sb.append("\n");

        }

        System.out.println(sb.toString());
    }

}