import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        input();

        HashMap<String, Integer> map = new HashMap<>();
        for(int n=0; n<N; n++){
            String word = br.readLine();

            if(word.length()>=M) map.put(word, map.getOrDefault(word, 0)+1);

        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int cnt1 = map.get(o1);
                int cnt2 = map.get(o2);

                if(cnt1==cnt2){
                    if(o1.length()==o2.length()){
                        return o1.compareTo(o2);
                    }
                    return o2.length()-o1.length();
                }
                return cnt2-cnt1;
            }
        });

        for(String str : list){
            sb.append(str).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


    }
}