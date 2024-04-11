import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Long, Long> map;
    static long P;
    static long Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();

        map.put(0L, 1L);

        if(N==0) System.out.println(1);
        else System.out.println(dp(N));
    }

    public static long dp(long n){
        if(map.containsKey(n)) return map.get(n);

        long p = n/P;
        long q = n/Q;

        map.put(n, dp(p)+dp(q));
        return map.get(n);
    }
}