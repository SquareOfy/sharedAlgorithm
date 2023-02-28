import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			seq[n] = Integer.parseInt(st.nextToken());
		}
		
		int cnt1 = 1;
		int cnt2 = 1;
		
		int max =1;
		for (int i = 0; i < N-1; i++) {
		

			if (seq[i] <= seq[i + 1]) {		
				cnt1++;
			}else {
				cnt1=1;
			}
			max = Math.max(max, cnt1);
		}
		
		for (int i = 0; i < N-1; i++) {
			if (seq[i] >= seq[i + 1]) {
				cnt2 ++;
			}else {
				cnt2=1;
			}
			max = Math.max(max, cnt2);
		}
		
		sb.append(max);
		System.out.println(sb.toString());
	}

}