import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static String T;
    static String S;
    static boolean flag;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
        flag = false;
        set = new HashSet<>();
        set.add(S);
        change(T);
        if(flag) System.out.println(1);
        else System.out.println(0);


    }

    public static void change(String str){
        if(str.equals(S)) {
            flag = true;
            return;
        }else if(str.length()==S.length()){
            return;
        }

        //A가 제일 끝에 있으면 떼기
        if(str.charAt(str.length()-1)=='A') change(str.substring(0,str.length()-1));
        //B가 제일 앞에 있으면 떼고 뒤집기
        if(str.charAt(0)=='B'){
            StringBuilder sb = new StringBuilder(str.substring(1));
            String reverse = sb.reverse().toString();
            change(reverse);

        }


    }
}