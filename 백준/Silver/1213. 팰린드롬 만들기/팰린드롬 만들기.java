import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int[] cnt = new int[26];
        //A 는 65번

        for(int i=0; i<str.length(); i++){
            cnt[(int)str.charAt(i)-65]++;
        }

        int oddCnt =0;
        boolean isOdd = str.length()%2!=0;
        boolean isPossible = true;
        for(int i=0; i<26; i++){
            if(cnt[i]%2!=0) oddCnt ++;
            if((isOdd && oddCnt>2)|| (!isOdd&&oddCnt>0)){
                isPossible=false;
                break;
            }
        }

        if(!isPossible) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        char[] answer = new char[str.length()];
        int idx =0;
        for(int i=0; i<26; i++){
            if(cnt[i]%2!=0) {
                answer[str.length()/2] = (char)(i+65);
                cnt[i]--;
            }
            while(cnt[i]>0){
                answer[idx] = (char)(i+65);
                answer[str.length()-idx-1] = (char)(i+65);
                idx++;
                cnt[i]-=2;
            }
        }

        for(int i=0; i<str.length(); i++){
            sb.append(answer[i]);
        }

        System.out.println(sb.toString());
    }
}