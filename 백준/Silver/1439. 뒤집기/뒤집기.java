import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char[] s = str.toCharArray();
		int cnt =0;
		for(int i=0; i<s.length-1; i++) {
			if(s[i]!=s[i+1]) {
				cnt ++;
			}
		}
		
		if(cnt%2 ==0 ) {
			cnt = cnt/2;
		}else cnt = cnt/2 +1;
		
		System.out.println(cnt);

	}

}
