import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int A,B;
    static HashMap<Integer, Integer> set;
    static int[] setB;
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        input();


        if(set.isEmpty()){
            sb.append(0);
        }else{
            Set<Integer>  keys = set.keySet();
            Integer[] arr = keys.toArray(new Integer[0]);
            Arrays.sort(arr);
            sb.append(arr.length).append("\n");
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.println(sb.toString());

    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        set = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int a=0; a<A; a++){
            int num = Integer.parseInt(st.nextToken());
            set.put(num, 0);
        }

        st = new StringTokenizer(br.readLine());
        for(int b =0; b<B; b++){
            int num = Integer.parseInt(st.nextToken());
            if(set.containsKey(num)){
                set.remove(num);
            }
        }
    }
}