import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String target = br.readLine();

        int cnt = 0;
        int idx = 0;
        //찾는 시작지점
        outer : for(int st = 0; st<str.length(); st++) {

            for (int i = 0; i < target.length(); i++) {
                if(st+i>=str.length()) {
                    idx =0;
                    continue outer;
                }

                if (str.charAt(st+i) == target.charAt(idx)) {
                    idx++;
                    if (idx == target.length()) {
                        cnt++;

                        idx = 0;
                        st +=i;
                    }
                } else {
                    idx = 0;
                    continue outer;
                }
            }
        }

        System.out.println(cnt);

    }
}