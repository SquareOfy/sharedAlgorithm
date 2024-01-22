import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.next();


        int q = str.length() / 10;
        int r = str.length() %10;
        if(r!=0) q ++;
        int idx = 0;

        for(int i=0; i<q; i++){
            if(idx+10<=str.length()){
                sb.append(str.substring(idx, idx+10));
            }else{
                sb.append(str.substring(idx));
            }
            idx+=10;
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }
}