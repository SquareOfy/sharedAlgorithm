import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N;
    static int[] dp;
    static int[] arr;
    static PriorityQueue<Long> pq;


    public static void main(String[] args) {

        T = scan.nextInt();
        for(int t=0; t<T; t++){
            pq = new PriorityQueue<>();
            N = scan.nextInt();
            for(int n=0; n<N; n++){
                pq.add(scan.nextLong());
            }


            long result = 0;

            while(pq.size()>=2){
                long a = pq.poll();
                long b = pq.poll();

                result+= a+b;
                pq.add(a+b);

            }

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());


    }




    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}