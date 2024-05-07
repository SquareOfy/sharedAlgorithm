import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if(K==1){
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            int[] alpha = new int[26];
            int min = 10001;
            int max = 0;

            for(int i=0; i<str.length(); i++) {
                alpha[str.charAt(i)-'a'] ++;
            }

            for(int i=0; i<str.length(); i++){
                if(alpha[str.charAt(i)-'a']<K) continue;
                int cnt =1;
                for(int j=i+1; j<str.length(); j++){
                    if(str.charAt(i)==str.charAt(j)) cnt++;
                    if(cnt==K){
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
            }
            if(min==10001 && max==0){
                sb.append(-1).append("\n");
            }else{
                sb.append(min).append(" ").append(max).append("\n");
            }




        }
        System.out.println(sb.toString());
    }
}