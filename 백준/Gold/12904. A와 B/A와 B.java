import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String S, T;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(pro(S, T));
    }

    public static int pro(String original, String target) {

        String str = target;
        while (true) {
            if(str.length()<=original.length()) return 0;
            //문자열 맨 뒤가 A이면 A 떼기
            if (str.charAt(str.length() - 1) == 'A') {

                str = str.substring(0, str.length() - 1);
            } else {
                //문자열 맨 뒤가 B면 떼고 뒤집기
                str = str.substring(0, str.length() - 1);
                str = reverse(str);
            }
            if(str.equals(original)) return 1;

        }


    }

    public static String reverse(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }


    public static void input() throws IOException {
        S = br.readLine();
        T = br.readLine();
    }
}