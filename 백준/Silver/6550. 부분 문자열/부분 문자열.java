import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        StringBuilder sb = new StringBuilder();
        while (true) {

            str = br.readLine();
            if(str == null) break;
            st = new StringTokenizer(str);
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int idx = 0;

            for(int i=0; i<str2.length(); i++){
                if(str1.charAt(idx) == str2.charAt(i)){
                    idx++;
                }
                if(idx == str1.length()) break;
            }
            if(idx==str1.length()) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");


        }

        System.out.println(sb.toString());
    }


}