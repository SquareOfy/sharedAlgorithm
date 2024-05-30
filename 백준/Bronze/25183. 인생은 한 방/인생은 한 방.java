import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static boolean isLottoWinner(int n, String s) {
		int count = 1;
		for(int i=1;i<n;i++) {
			char c = s.charAt(i);
			char before = s.charAt(i-1);
			if(c-before==1||before-c==1) {
				count++;
				if(count==5) return true;
			}else {
				count=1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		System.out.println(isLottoWinner(n, s)?"YES":"NO");
		br.close();
	}
}