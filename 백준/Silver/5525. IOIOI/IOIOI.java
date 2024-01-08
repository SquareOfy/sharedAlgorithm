import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder("IOI");

        for(int n=0; n<N-1; n++){
            sb.append("OI");
        }
        String target = sb.toString();

        int[] table = makeTable(target);

        int cnt = 0;



        int idx =0;
        for(int i=0; i<M; i++){

            while(idx>0 && s.charAt(i) != target.charAt(idx)){
                idx = table[idx-1];
            }
            if(s.charAt(i)==target.charAt(idx)) {
                if (idx == target.length()-1) {
                    cnt++;
//                    System.out.printf("%d번째에서 찾았습니다. \n", i-target.length()+2);
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }

        System.out.println(cnt);
    }


    static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++){
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)){
                idx = table[idx-1];
            }
            if(pattern.charAt(i)==pattern.charAt(idx)){
                table[i] = ++idx;
            }

        }
        return table;
    }
}