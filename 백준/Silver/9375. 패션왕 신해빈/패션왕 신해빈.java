import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static  HashMap<String, Integer> map ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
           map= new HashMap<>();
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
//                clothes[n][0] = st.nextToken();
//                clothes[n][1] = st.nextToken();

                if(map.containsKey(kind)) map.put(kind, map.get(kind)+1);
                else map.put(kind, 1);





            }

            int result = 1;
            for(int val : map.values()){
                result *= (val+1);
            }


            System.out.println(result-1);


        }
    }



}